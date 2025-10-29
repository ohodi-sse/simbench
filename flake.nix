{
  description = "The code similarity benchmark";

  inputs = {
    nixpkgs.url = "github:nixos/nixpkgs?ref=nixos-unstable";
  };

  outputs = {
    self,
    nixpkgs,
  }: let
    overlays = [
      (final: prev: {
        needed = with final; [
          jdt-language-server
          jdk
          maven
          final.jvm2json
        ];
        jpamb = final.callPackage ./build.nix {inherit self;};
      })
    ];
    perSystem = {
      systems ? [
        "x86_64-linux"
        "x86_64-darwin"
      ],
      do,
    }:
      nixpkgs.lib.genAttrs systems (
        system:
          do {
            inherit system;
            pkgs = import nixpkgs {inherit system overlays;};
          }
      );
  in {
    devShells = perSystem {
      do = {pkgs, ...}: {
        default = pkgs.mkShell {
          name = "python";
          buildInputs = [
            (pkgs.python3.withPackages (py: with py; [uv numpy]))
          ];
        };
      };
    };
  };
}
