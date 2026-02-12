// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: lstore_0       
        //     4: new             Ljava/util/Scanner;
        //     7: dup            
        //     8: getstatic       java/lang/System.in:Ljava/io/InputStream;
        //    11: invokespecial   java/util/Scanner.<init>:(Ljava/io/InputStream;)V
        //    14: astore_2       
        //    15: new             Ljava/lang/String;
        //    18: invokespecial   java/lang/String.<init>:()V
        //    21: aload_2        
        //    22: invokevirtual   java/util/Scanner.nextLine:()Ljava/lang/String;
        //    25: invokevirtual   java/lang/String.toCharArray:()[C
        //    28: astore          4
        //    30: iconst_0       
        //    31: istore_3       
        //    32: iconst_0       
        //    33: istore          5
        //    35: iload           5
        //    37: iconst_3       
        //    38: if_icmpge       88
        //    41: iconst_0       
        //    42: istore          6
        //    44: iload           5
        //    46: istore          7
        //    48: iload           7
        //    50: iconst_3       
        //    51: if_icmpge       73
        //    54: aload           4
        //    56: iload           7
        //    58: caload         
        //    59: bipush          82
        //    61: if_icmpne       73
        //    64: iinc            6, 1
        //    67: iinc            7, 1
        //    70: goto            48
        //    73: iload_3        
        //    74: iload           6
        //    76: if_icmpge       82
        //    79: iload           6
        //    81: istore_3       
        //    82: iinc            5, 1
        //    85: goto            35
        //    88: getstatic       java/lang/System.out:Ljava/io/PrintStream;
        //    91: iload_3        
        //    92: invokevirtual   java/io/PrintStream.println:(I)V
        //    95: aload_2        
        //    96: invokevirtual   java/util/Scanner.close:()V
        //    99: goto            119
        //   102: invokevirtual   java/lang/Exception.printStackTrace:()V
        //   105: aload_2        
        //   106: invokevirtual   java/util/Scanner.close:()V
        //   109: goto            119
        //   112: astore_0       
        //   113: aload_2        
        //   114: invokevirtual   java/util/Scanner.close:()V
        //   117: aload_0        
        //   118: athrow         
        //   119: invokestatic    java/lang/System.currentTimeMillis:()J
        //   122: lload_0        
        //   123: lsub           
        //   124: l2d            
        //   125: ldc2_w          1000.0
        //   128: ddiv           
        //   129: pop2           
        //   130: return         
        //    StackMapTable: 00 08 FF 00 23 00 05 04 07 00 09 01 07 00 02 01 00 00 FD 00 0C 01 01 FA 00 18 FA 00 08 F9 00 05 FF 00 0D 00 02 04 07 00 09 00 01 07 00 04 FF 00 09 00 03 00 00 07 00 09 00 01 07 00 08 FF 00 06 00 01 04 00 00
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  15     95     102    112    Ljava/lang/Exception;
        //  15     95     112    119    Any
        //  102    105    112    119    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException: Cannot read field "references" because "newVariable" is null
        //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:2945)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2501)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:203)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:93)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:868)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:761)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:638)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:605)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:195)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:162)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:137)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:333)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:254)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:129)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
}
