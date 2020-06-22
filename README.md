# Catacomb

Catacomb is *totally not* a new economy API for Minecraft, aiming to fix many
of the flaws and inconsistencies in existing APIs while providing support for
multiple platforms.

While it's *totally not* a Vault replacement, it has more kittens than Vault,
so you should definitely use it instead of Vault.

## Project structure

The project is split into the following modules:

- `catacomb-common-api`:     cross platform service interfaces
- `catacomb-<platform>-api`: helper methods for specific platforms, and 
                             includes the common API
- `catacomb-<platform>`:     plugins/mods for specific platforms, providing
                             the Catacomb API classes for other mods/plugins
                             on those platforms

## Usage

### For server admins

*This isn't ready yet, what are you doing here?*

Download and install the appropriate `catacomb-<platform>-<version>.jar`
file and place it in the plugins/mods folder for your platform.

### As a dependency

*This isn't published yet, so no Maven coordinates for now.*

In general, you'll want to depend on the `catacomb-<platform>-api` for your
platform. If you're creating a cross-platform plugin, you can alternatively 
depend on `catacomb-common-api` in your common module.

## Building

To build Catacomb's API and plugins, clone the repository and run
`./gradlew shadowJar`. You can find the output from each module under
`<module>/build/libs`.
