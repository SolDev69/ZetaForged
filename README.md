# SolTweaks

Formerly known as ZetaForged

SolTweaks is a Minecraft mod for version 1.17.1, utilizing the Fabric mod loader. It adds quality of life changes and utility/configuration tweaks. With features like uncapped fireball explosion power, fleshed out coordinate scaling, the revival of the Far Lands, and an expanded world border.

### Latest Update: [1.17.1] SolTweaks 1.2 alpha
### Latest Build: [1.17.1] SolTweaks 1.2 alpha
### Stable Build: [1.17.1] ZetaForged 1.1.0_02

## Features

- **Fireball Explosion Power**: Remove the limits imposed by Mojang in 1.17 and above on fireball explosion power, allowing for bedrock-breaking fireballs once more!
- **Noise Scaling**:
    - *Horizontal Scaling*: The old `coordinateScale` option from custom worlds, now using doubles instead of floats.
    - *Scaling on Individual Axis*: Modify noise scale individually on the X, Y, and Z axes, allowing the fringelands to be viewed in their full, unmodified vanilla glory!
    - *Vertical Scaling*: Adjust vertical scaling to influence terrain generation and elevation, unlocking the sky Far Lands and variants.
- **Far Lands Revival**: Reintroduces the Far Lands from earlier versions of Minecraft.
- **Expanded World Border**: Teleport beyond Minecraft's 30 million limit, with a default worldborder size of 2 billion blocks, expandable up to 4294967294 blocks.
- **Lush Nether**: A new, wetter version of the Nether featuring:
    - A base using the new Lush Caves biome.
    - A refreshing, vibrant atmosphere.
    - Future expansions, including custom structures and additional sub-biomes.
- **Keystone tools**: A new mysterious tool and armor set, what could this be?

## Installation

1. **Prerequisites**:
    - Minecraft 1.17.1 installed.
    - [Fabric Mod Loader](https://fabricmc.net/use/) installed.
    - [Fabric API](https://modrinth.com/mod/fabric-api) installed.

2. **Download**:
    - Obtain the latest release of SolTweaks from the [Modrinth site](https://modrinth.com/mod/zetaforged/).

3. **Install**:
    - Place the downloaded `.jar` file into your Minecraft `mods` folder:
        - Windows: `%appdata%/.minecraft/mods`
        - macOS: `~/Library/Application Support/minecraft/mods`
        - Linux: `~/.minecraft/mods`
    - Launch Minecraft using the Fabric profile.

## Configuration

After installation, configuration files will be generated in the `config` folder within your Minecraft directory. Edit these files to adjust mod settings, such as noise scale.

There are currently plans to move to ModMenu's config system soon.

## Development Status

SolTweaks is currently undergoing a code cleanup with plans to:
- Update to newer Minecraft versions.
- Add more features and improvements.

Stay up-to-date by checking the [dev/1.2 branch](https://github.com/SolDev69/ZetaForged/tree/dev/1.2) of the repository.

## Contributions

Contributions are welcome! If you'd like to contribute:
1. Fork the repository.
2. Make your changes.
3. Submit a pull request.

Please ensure your contributions  include proper documentation for any changes.

## License

This project currently has no license but plans to adopt a suitable open-source license soon. Contributions and forks must credit the original project and abide by the forthcoming license's terms.
