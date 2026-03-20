# What the project is used for?
This project is a style transfer and style inconsistency analysis tool for source code. 
It provides functionalities to extract coding style from reference code, 
analyze the style inconsistencies between source code and reference code, and transfer the coding style of source code to match the style of reference code.
It supports 20 style aspects, which are categorized into three groups: formatting style (e.g., indentation, spacing), syntactic style (e.g., variable declaration layout), and semantic style (e.g., order of if-else branches).
It supports multiple programming languages, including Java, Python, and C++.

# Running the Application

This application supports two execution modes: **Command-Line Interface (CLI)** mode and **Web (Server)** mode.
The execution mode is determined by the active Spring profile.

---

## CLI Mode

Run the application in CLI mode to perform style-related tasks from the command line:

```bash
java -jar <jar-file> --spring.profiles.active=cli <options>
```
The following options are available in CLI mode:
```
Options:
 -a,--analyze               Execute style inconsistencies analysis only
 -d,--directory <arg>       Output directory for style-transferred code
                            and analysis results.
 -e,--extract               Execute style extraction only
 -f,--file <arg>            Output file path for style-transferred code
                            and analysis results.
 -lang <arg>                Programming language: java, python, cpp.
 -override                  Override source code with style-transferred
                            code.
 -so,--style-output <arg>   Output file for style profile extracted from
                            reference code.
 -src <arg>                 Source file or directory path, multiple paths
                            are seperated by ';'.
 -target <arg>              Source file or directory path of reference
                            code, or path of a target style file. Multiple
                            paths are seperated by ';'.

Usage examples:
  Transfer style:    -src <path1;path2;...> -target <arg> [-f
<output_file> | -d <output_directory>] -so <style_output_file> -lang
<language>
  Extract style:     -e -target <path1;path2;...> -so <style_output_file>
-lang <language>
  Analyze style:     -a -src <path1;path2;...> -target <arg> [-f
<output_file> | -d <output_directory>] -lang <language>
```

## Server Mode

Run the application as a web server:
```
java -jar <jar-file> --spring.profiles.active=web
```