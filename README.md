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
java Main a=<algorithm> t=<list_type> o=<order> in=<input_type> v="<values>" s=<pause>
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

> ⚠️ For partial exam only Quick Sort is working

1. **BubbleSort with manual input (ascending):**
   ```bash
   java Main a=b t=n o=az in=m v="4,2,6,0" s=500
   ```
2. **SelectionSort with manual input (descending):**
   ```bash
   java Main a=s t=n o=za in=m v="4,2,6,0" s=500
   ```
3. **QuickSort with random input (descending):**
   ```bash
     java Main a=q t=c o=za in=m v="b,B,Z,a" s=500
   ```
## Diagram Classes

```mermaid
   classDiagram
    direction BT
    class Aengus {
        + Aengus()
        + pauseMusic() void
        + resumeMusic() void
        + playMusic(String, int) void
        + resetPlayer() void
        + adjustVolume(float) void
        + stopMusic() void
        boolean musicPaused
        boolean musicPlaying
    }
    class Algorithm {
        # Algorithm(AlgorithmConfigs)
        # displaySortedArray() void
        # compare(String, String) boolean
        # swap(int, int) void
        + sort() void
        # displayOriginalList() void
        # displayCurrentState() void
    }
    class AlgorithmConfigs {
        + AlgorithmConfigs(List~String~, String, int, boolean)
        - boolean isNumeric
        + typeOrder() String
        + elements() List~String~
        + skip() int
        boolean isNumeric
    }
    class App {
        + App(String[])
        + run() void
    }
    class AppConfigs {
        + AppConfigs(String, String, String, String, int, List~String~, int)
        + s() int
        + a() String
        + typeList() String
        + o() String
        + in() String
        + r() int
        + inputList() List~String~
        String typeListName
        String algorithmName
    }
    class ArgumentHandler {
        + ArgumentHandler(String[])
        - getOptionalIntArgumentByKey(String, int) int
        - getIntArgumentByKey(String) int
        + getArgumentByKey(String) String
        + createAppConfigs() AppConfigs
        + verify() void
    }
    class AsciiColor {
        <<enumeration>>
        - AsciiColor(String)
        - String code
        + customTextColor(int, int, int) String
        + valueOf(String) AsciiColor
        + customBackgroundColor(int, int, int) String
        + applyMultiple(String, AsciiColor[]) String
        + toEscapeCode() String
        + apply(String) String
        + values() AsciiColor[]
        String code
    }
    class BubbleSort {
        + BubbleSort(AlgorithmConfigs)
        + sort() void
        - bubbleSort() void
    }
    class GenerateList {
        + GenerateList()
        - generateNumbers() String
        - makeList() String
        - generateCharacters() String
        + generate(String, int) String
    }
    class IArgumentHandler {
        <<Interface>>
        + createAppConfigs() AppConfigs
        + verify() void
    }
    class ISortAlgorithm~T~ {
        <<Interface>>
        + sort(T[], SortingVisualizer) void
    }
    class IValidateArguments {
        <<Interface>>
        + typeListIsCharacter(String) boolean
        + validateLengthList(String) boolean
        + validateUserInput(String, String) boolean
        + validateTypeList(String) boolean
        + validateSortingOrder(String) boolean
        + validateSourceListValues(String) boolean
        + validadeQuantityMinimumArgument(String[]) boolean
        + validateIterationTime(String) boolean
        + validateTypeSortAlgorithm(String) boolean
    }
    class IVisionRenderer {
        <<Interface>>
        + clear(int) void
        + renderPressStart() void
        + renderLogo() void
        + renderWelcome() void
    }
    class InputListHandler {
        + InputListHandler()
        + InputListHandler(String, String)
        + handleInput() boolean
        + splitInputList() String[]
        + manipulateItemList(String) boolean
        + convertListStringToIntegers(List~String~) List~Integer~
        List~Integer~ asIntegers
        List~String~ asString
    }
    class Letters {
        <<enumeration>>
        + Letters()
        + contains(Character) boolean
        + fromValue(Character) Letters
        + valueOf(String) Letters
        + values() Letters[]
        + count() int
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
        + showMessage(String) void
        + showError(String) void
    }
    class Numbers {
        <<enumeration>>
        - Numbers(int)
        - int value
        + values() Numbers[]
        + valueOf(String) Numbers
        + contains(Integer) boolean
        + count() int
        + fromValue(Integer) Numbers
        Numbers[] array
        int value
        Numbers random
    }
    class QuickSort {
        + QuickSort(AlgorithmConfigs)
        - quickSort(int, int) void
        + sort() void
        - partition(int, int) int
    }
    class Rules {
        <<enumeration>>
        - Rules(Object)
        + valueOf(String) Rules
        + values() Rules[]
        String text
        int int
    }
    class SortingVisualizer~T~ {
        + SortingVisualizer(T[], int)
        - findMaxValue(T[]) T
        - convertToHeight(T, T, int) int
        + draw() void
        - generateRandomColors() void
        + updateArray(T[]) void
        # paintComponent(Graphics) void
    }
    class Texts {
        <<enumeration>>
        - Texts(String)
        - String text
        + tableHeader(AppConfigs) String
        + valueOf(String) Texts
        + values() Texts[]
        String text
    }
    class ValidateHandler {
        + ValidateHandler()
        + validadeQuantityMinimumArgument(String[]) boolean
        + validateTypeList(String) boolean
        + validateSortingOrder(String) boolean
        + typeListIsCharacter(String) boolean
        + validateSourceListValues(String) boolean
        + validateLengthList(String) boolean
        + validateUserInput(String, String) boolean
        + validateTypeSortAlgorithm(String) boolean
        + validateIterationTime(String) boolean
    }
    class VisionRenderer {
        + VisionRenderer()
        - AppConfigs configs
        + clear(int) void
        + renderVisualizer() void
        + sleep(int) void
        + renderLogo() void
        + renderHeader() void
        + loading() void
        + renderPressStart() void
        + renderWelcome() void
        AppConfigs configs
    }

    Aengus  ..>  Mercury : «create»
    Aengus "1" *--> "mercury 1" Mercury
    Algorithm  ..>  Mercury : «create»
    Algorithm "1" *--> "mercury 1" Mercury
    App  ..>  AlgorithmConfigs : «create»
    App "1" *--> "configs 1" AppConfigs
    App  ..>  ArgumentHandler : «create»
    App "1" *--> "argumentHandler 1" ArgumentHandler
    App  ..>  BubbleSort : «create»
    App  ..>  Mercury : «create»
    App "1" *--> "mercury 1" Mercury
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
    BubbleSort  -->  Algorithm
    Main  ..>  App : «create»
    QuickSort  -->  Algorithm
    ValidateHandler  ..>  IValidateArguments
    ValidateHandler  ..>  InputListHandler : «create»
    VisionRenderer "1" *--> "configs 1" AppConfigs
    VisionRenderer  ..>  IVisionRenderer
    VisionRenderer  ..>  InputListHandler : «create»
    VisionRenderer "1" *--> "listHandler 1" InputListHandler
    VisionRenderer  ..>  Mercury : «create»
    VisionRenderer "1" *--> "mercury 1" Mercury
    VisionRenderer  ..>  SortingVisualizer~T~ : «create»
   ```