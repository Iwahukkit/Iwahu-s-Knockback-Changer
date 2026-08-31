[![LOGO](https://raw.githubusercontent.com/Iwahukkit/Iwahu-s-Knockback-Changer/refs/heads/main/iwahusknockback.png)]()

A lightweight, high-performance Spigot/Paper 1.8 knockback management plugin designed to give server owners precise control over PvP physics and server combat feel.

---

[![Features](https://raw.githubusercontent.com/Iwahukkit/Iwahu-s-Knockback-Changer/refs/heads/main/features.png)]()
- **Zero Relog Advantage:** Operates via instant vector manipulation without relying on custom proxy or core hacks.
- **Customizable Presets:** Ready-to-use configurations modeled after popular PvP networks.
- **Optimized Performance:** Built with tick-delay logic to prevent vanilla combat glitches and aerial over-extension.

---

[![Preset](https://raw.githubusercontent.com/Iwahukkit/Iwahu-s-Knockback-Changer/refs/heads/main/presets.png)]()
The `config.yml` includes pre-configured settings inspired by legendary practice networks:
- **\Min*m*n Clb (M*C)\**
- **\K*hi\**
- **\Badli*n\**
- **\Lun*r\**

---

[![CONF](https://raw.githubusercontent.com/Iwahukkit/Iwahu-s-Knockback-Changer/refs/heads/main/config.png)]()

```yaml
# Iwahu's Knockback Configuration
# Customize horizontal, vertical, and extra modifiers below.

settings:
  preset: "MinemenClub"

presets:
  MinemenClub:
    horizontal: 0.40
    vertical: 0.40
    extra-horizontal: 0.42
    extra-vertical: 0.08
  Kohi:
    horizontal: 0.38
    vertical: 0.38
    extra-horizontal: 0.40
    extra-vertical: 0.08
  Badlion:
    horizontal: 0.39
    vertical: 0.40
    extra-horizontal: 0.41
    extra-vertical: 0.08
  Lunar:
    horizontal: 0.40
    vertical: 0.39
    extra-horizontal: 0.40
    extra-vertical: 0.08
