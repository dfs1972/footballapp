# Fix Team Color Mismatches

The application is displaying incorrect colors for certain teams (notably Aberdeen and Hibernian) because the hardcoded IDs in `TeamColorOverrides.kt` do not match the IDs used in the `team-colours.json` data source. This causes the application to either use a fallback color or, worse, apply the color of a different team that happens to share the mismatched ID.

## Proposed Changes

### Utils Component

#### [MODIFY] [TeamColorOverrides.kt](file:///C:/Users/watt3/Desktop/footballapp/android/app/src/main/java/com/example/footballapp/util/TeamColorOverrides.kt)

I will update the `overrides` map to use the correct `apiFootballTeamId` values found in `team-colours.json`. I will also synchronize the hex colors with the "correct" values specified in the JSON file where appropriate.

**Corrected Mapping:**

| Team | New ID | Color (Hex) | Note |
| :--- | :--- | :--- | :--- |
| Celtic | 247 | #018749 | Kept Green (Override) |
| Rangers | 257 | #076FDF | Updated ID |
| Kilmarnock | 250 | #0059A3 | Kept Blue (Override) |
| Hearts | 254 | #54243A | Updated ID and Color |
| Hibernian | 249 | #057430 | Updated ID and Color |
| Aberdeen | 252 | #CC0000 | Updated ID and Color |
| Motherwell | 256 | #FFBB00 | Updated ID and Color |
| St Mirren | 251 | #000000 | Kept Black (Override) |
| Dundee United | 1386 | #FF4C1C | Updated ID and Color |
| St Johnstone | 258 | #005CAB | Updated ID |
| Livingston | 255 | #F2D202 | New Entry |

## Verification Plan

### Automated Tests
- I will verify that the project builds successfully after the changes.

### Manual Verification
- The user should run the app and verify that Aberdeen now displays as Red (`#CC0000`) and Hibernian as Green (`#057430`).
- Check other SPFL teams like Hearts (Maroon) and Motherwell (Yellow/Amber) to ensure their colors are also correct now.
