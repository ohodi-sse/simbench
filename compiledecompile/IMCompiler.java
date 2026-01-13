import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.charset.StandardCharsets;
import java.io.IOException;

import javax.tools.*;
import javax.tools.JavaFileObject.Kind;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.Collections;
import java.util.List;


public class IMCompiler {
    public static void main(String[] args) throws Exception {

        if (args.length != 1) {
            System.err.println("Usage: java ReadFileToString <file-path>");
            System.exit(1);
        }

        try {
            String sourceCode = readFile(args[0]);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            System.exit(2);
        }

        String sourceCode = readFile(args[0]);
        String className = "com.example.Main";


        // 2. Create in-memory source and class files
        InMemorySourceFile sourceFile = new InMemorySourceFile(className, sourceCode);
        InMemoryClassFile classFile = new InMemoryClassFile(className);
 
        // 3. Get compiler and validate
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        if (compiler == null) {
            throw new IllegalStateException("JDK required (no compiler found).");
        }
 
        // 4. Compile setup
        CompilationDiagnostics diagnostics = new CompilationDiagnostics();
        try (JavaFileManager standardFM = compiler.getStandardFileManager(diagnostics.listener(), null, null)) {
            JavaFileManager fileManager = new InMemoryFileManager(standardFM, classFile);
            List<String> options = List.of("-classpath", System.getProperty("java.class.path"));
 
            // 5. Compile task
            JavaCompiler.CompilationTask task = compiler.getTask(
                null, fileManager, diagnostics.listener(), options, null, Collections.singletonList(sourceFile)
            );
 
            if (!task.call() || diagnostics.hasErrors()) {
                throw new RuntimeException("Compilation failed:\n" + diagnostics.getErrorMessage());
            }

            // Write to stdout
            byte[] bytecode = classFile.getBytecode();
            System.out.write(bytecode);
        }
    }
 
    public static String readFile(String filePath) throws IOException {
        Path path = Path.of(filePath);
        return Files.readString(path, StandardCharsets.UTF_8);
    }

    // In-memory source file
    static class InMemorySourceFile extends SimpleJavaFileObject {
        private final CharSequence content;
 
        InMemorySourceFile(String className, CharSequence content) {
            super(URI.create("string:///" + className.replace('.', '/') + Kind.SOURCE.extension), Kind.SOURCE);
            this.content = content;
        }
 
        @Override
        public CharSequence getCharContent(boolean ignoreEncodingErrors) {
            return content;
        }
    }
 
    // In-memory class file
    static class InMemoryClassFile extends SimpleJavaFileObject {
        private final ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
 
        InMemoryClassFile(String className) {
            super(URI.create("mem:///" + className.replace('.', '/') + Kind.CLASS.extension), Kind.CLASS);
        }
 
        @Override
        public OutputStream openOutputStream() {
            return byteOut;
        }
 
        byte[] getBytecode() {
            return byteOut.toByteArray();
        }
    }
 
    // Custom file manager to avoid disk I/O
    static class InMemoryFileManager extends ForwardingJavaFileManager<JavaFileManager> {
        private final InMemoryClassFile classFile;
 
        InMemoryFileManager(JavaFileManager standardFM, InMemoryClassFile classFile) {
            super(standardFM);
            this.classFile = classFile;
        }
 
        @Override
        public JavaFileObject getJavaFileForOutput(Location loc, String name, Kind kind, FileObject sibling) throws IOException{
            
            return (kind == Kind.CLASS && loc == StandardLocation.CLASS_OUTPUT) ? classFile : super.getJavaFileForOutput(loc, name, kind, sibling);
        
        }
    }
 
    // Diagnostics handler
    static class CompilationDiagnostics {

        private final DiagnosticCollector<JavaFileObject> collector =
                new DiagnosticCollector<>();

        public DiagnosticListener<JavaFileObject> listener() {
            return collector;
        }

        public boolean hasErrors() {
            return collector.getDiagnostics()
                            .stream()
                            .anyMatch(d -> d.getKind() == Diagnostic.Kind.ERROR);
        }

        public String getErrorMessage() {
            StringBuilder sb = new StringBuilder();
            for (Diagnostic<? extends JavaFileObject> d : collector.getDiagnostics()) {
                if (d.getKind() == Diagnostic.Kind.ERROR) {
                    sb.append("Error at line ")
                    .append(d.getLineNumber())
                    .append(": ")
                    .append(d.getMessage(null))
                    .append("\n");
                }
            }
            return sb.toString();
        }

        public List<Diagnostic<? extends JavaFileObject>> getAllDiagnostics() {
            return collector.getDiagnostics();
        }
    }
}
