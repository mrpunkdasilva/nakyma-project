# SAV Project

# About
The Sorting Algorithm Viewer (SAV) is a Java application that implements sorting algorithms, allowing step-by-step visualization of each iteration through graphics represented by asterisks.
## Warning!!
This project is incomplete, the only alghorithm working is the **QuickSort**
# Features
- Implements the following sorting algorithms:
    - **BubbleSort**
    - **SelectionSort**
    - **QuickSort**
- Step-by-step visualization of each iteration in the form of asterisk graphics.
- Customization via Command-Line Interface (CLI) arguments.

## Usage

Run the program by providing the necessary parameters via the command line.

### Argument Format
```
java SAV a=<algorithm> t=<list_type> o=<order> in=<input_type> v="<values>" s=<pause>
```

### Argument Descriptions
| Argument       | Description                                                                                                   |
|----------------|---------------------------------------------------------------------------------------------------------------|
| `a`            | Sorting algorithm (`b` = BubbleSort, `s` = SelectionSort, `q` = QuickSort).                                   |
| `t`            | List type (`n` = numbers, `c` = character).                                                                   |
| `o`            | Order (`az` = ascending, `za` = descending).                                                                  |
| `in`           | Input type (`r` = random, `m` = manual).                                                                      |
| `v`            | Values separated by commas (required if `in=m`), if not put `r=x`, x being the qtd. of numbers to be generated. |
| `s`            | Pause between iterations (in milliseconds).                                                                   |

### Usage Examples

1. **BubbleSort with manual input (ascending):**
   ```bash
   java SAV a=b t=n o=az in=m v="4,2,6,0" s=500
   ```

2. **SelectionSort with manual input (descending):**
   ```bash
   java SAV a=s t=n o=za in=m v="4,2,6,0" s=500
   ```
3. **QuickSort with random input (descending):**
   ```bash
     java SAV a=q t=c o=za in=m v="b,B,Z,a" s=500
   ```
## Diagram Classes

```mermaid
    classDiagram
    direction BT
    class Aengus {
        + Aengus()
        + adjustVolume(float) void
        + stopMusic() void
        + resumeMusic() void
        + resetPlayer() void
        + pauseMusic() void
        + playMusic(String, int) void
        boolean musicPaused
        boolean musicPlaying
    }
    class App {
        + App(String[])
        + run() void
    }
    class AppConfigs {
        + AppConfigs(String, String, String, String, int, List~String~, int)
        + inputList() List~String~
        + o() String
        + a() String
        + in() String
        + r() int
        + s() int
        + typeList() String
    }
    class ArgumentHandler {
        + ArgumentHandler(String[])
        + createAppConfigs() AppConfigs
        + verify() void
        - getOptionalIntArgumentByKey(String, int) int
        - getIntArgumentByKey(String) int
        + getArgumentByKey(String) String
    }
    class AsciiColor {
        <<enumeration>>
        - AsciiColor(String)
        - String code
        + applyMultiple(String, AsciiColor[]) String
        + values() AsciiColor[]
        + valueOf(String) AsciiColor
        + toEscapeCode() String
        + customBackgroundColor(int, int, int) String
        + customTextColor(int, int, int) String
        + apply(String) String
        String code
    }
    class GenerateList {
        + GenerateList()
        - generateCharacters() String
        + generate(String, int) String
        - makeList() String
        - generateNumbers() String
    }
    class IArgumentHandler {
        <<Interface>>
        + verify() void
        + createAppConfigs() AppConfigs
    }
    class IValidateArguments {
        <<Interface>>
        + validateSourceListValues(String) boolean
        + validateLengthList(String) boolean
        + typeListIsCharacter(String) boolean
        + validadeQuantityMinimumArgument(String[]) boolean
        + validateIterationTime(String) boolean
        + validateSortingOrder(String) boolean
        + validateTypeSortAlgorithm(String) boolean
        + validateTypeList(String) boolean
        + validateUserInput(String, String) boolean
    }
    class IVisionRenderer {
        <<Interface>>
        + renderLogo() void
        + clear(int) void
        + renderPressStart() void
        + renderWelcome() void
    }
    class InputListHandler {
        + InputListHandler(String, String)
        + InputListHandler()
        + splitInputList() String[]
        + convertListStringToIntegers(List~String~) List~Integer~
        + handleInput() boolean
        + manipulateItemList(String) boolean
        List~Integer~ asIntegers
        List~String~ asString
    }
    class Letters {
        <<enumeration>>
        + Letters()
        + valueOf(String) Letters
        + count() int
        + contains(Character) boolean
        + fromValue(Character) Letters
        + values() Letters[]
        Letters random
        Letters[] array
        Character value
    }
    class Main {
        + Main()
        + main(String[]) void
    }
    class Mercury {
        + Mercury()
        + showError(String) void
        + showMessage(String) void
    }
    class Numbers {
        <<enumeration>>
        - Numbers(int)
        - int value
        + count() int
        + values() Numbers[]
        + valueOf(String) Numbers
        + fromValue(Integer) Numbers
        + contains(Integer) boolean
        int value
        Numbers[] array
        Numbers random
    }
    class QuickSort {
        + QuickSort(AppConfigs)
        - partition(int, int) int
        + displaySortedArray() void
        - quickSort(int, int) void
        - swap(int, int) void
        + sort() void
    }
    class Rules {
        <<enumeration>>
        - Rules(Object)
        + values() Rules[]
        + valueOf(String) Rules
        String text
        int int
    }
    class Texts {
        <<enumeration>>
        - Texts(String)
        - String text
        + values() Texts[]
        + HEADER_ARGS() ArrayList~String~
        + valueOf(String) Texts
        String text
    }
    class ValidateHandler {
        + ValidateHandler()
        + validateIterationTime(String) boolean
        + validateTypeSortAlgorithm(String) boolean
        + validateSourceListValues(String) boolean
        + validateSortingOrder(String) boolean
        + validadeQuantityMinimumArgument(String[]) boolean
        + validateTypeList(String) boolean
        + validateLengthList(String) boolean
        + validateUserInput(String, String) boolean
        + typeListIsCharacter(String) boolean
    }
    class VisionRenderer {
        + VisionRenderer()
        + clear(int) void
        + sleep(int) void
        + loading() void
        + renderPressStart() void
        + renderMatrix(List~String~) void
        - renderHeader() void
        + renderLogo() void
        + renderWelcome() void
    }

    Aengus  ..>  Mercury : «create»
    Aengus "1" *--> "mercury 1" Mercury
    App "1" *--> "configs 1" AppConfigs
    App  ..>  ArgumentHandler : «create»
    App "1" *--> "argumentHandler 1" ArgumentHandler
    App  ..>  QuickSort : «create»
    App  ..>  VisionRenderer : «create»
    App "1" *--> "vision 1" VisionRenderer
    ArgumentHandler  ..>  AppConfigs : «create»
    ArgumentHandler "1" *--> "generateList 1" GenerateList
    ArgumentHandler  ..>  GenerateList : «create»
    ArgumentHandler  ..>  IArgumentHandler
    ArgumentHandler  ..>  InputListHandler : «create»
    ArgumentHandler "1" *--> "mercury 1" Mercury
    ArgumentHandler  ..>  Mercury : «create»
    ArgumentHandler "1" *--> "validate 1" ValidateHandler
    ArgumentHandler  ..>  ValidateHandler : «create»
    Main  ..>  App : «create»
    ValidateHandler  ..>  IValidateArguments
    ValidateHandler  ..>  InputListHandler : «create»
    VisionRenderer  ..>  IVisionRenderer
    VisionRenderer "1" *--> "listHandler 1" InputListHandler
    VisionRenderer  ..>  InputListHandler : «create»
    VisionRenderer  ..>  Mercury : «create»
    VisionRenderer "1" *--> "mercury 1" Mercury 
   ```