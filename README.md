# SAV Project

# About
The Sorting Algorithm Viewer (SAV) is a Java application that implements sorting algorithms, allowing step-by-step visualization of each iteration through graphics represented by asterisks.

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
| Argument       | Description                                                               |
|----------------|---------------------------------------------------------------------------|
| `a`            | Sorting algorithm (`b` = BubbleSort, `s` = SelectionSort, `q` = QuickSort). |
| `t`            | List type (`n` = numbers, `s` = strings).                                |
| `o`            | Order (`az` = ascending, `za` = descending).                             |
| `in`           | Input type (`r` = random, `m` = manual).                                 |
| `v`            | Values separated by commas (required if `in=m`).                         |
| `s`            | Pause between iterations (in milliseconds).                              |

### Usage Examples

1. **BubbleSort with manual input (ascending):**
   ```bash
   java SAV a=b t=n o=az in=m v="4,2,6,0" s=500
   ```

2. **SelectionSort with manual input (descending):**
   ```bash
   java SAV a=s t=n o=za in=m v="4,2,6,0" s=500
   ```


