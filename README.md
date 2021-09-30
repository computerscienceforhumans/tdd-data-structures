# tdd-data-structures
This repository is a collection of data structures taken from real situations that suffer from a variety of code smells. In some cases, they may not even work. **The purpose of this is to enable refactoring practice**, since on-the-job practice of refactoring can be scary at first.

If you want to practice your refactoring on these data structures, feel free to fork the project and give it a go. Then have someone more experienced with refactoring take a look at it and give you pointers.

# Versioning Stuff
- Uses Junit5 and Java 8.0

# Assorted Guidelines:
- "spec" folder structure should mimic "src" folder structure, but with "Tests" added to the end of each package name.
- Commit/push when you achieve a passing test.
- Commit/push when you achieve a failing test. (NOTE: this is ONLY at the initial creation of the failing test. It is not during the Refactor phase of TDD, nor is it when you were poking around at the code and something broke. If you feel the need to commit to not lose progress, you have taken too big of a bite and should start again from the previous commit).
- Commits are in present tense, short and to the point.
- If a commit message is particularly long or contains more than one conjunction, "git reset --hard" and do it again
but with smaller steps this time. It is practice after all :)
- Comments do not need to mention updating the readme. That is implied. Hint hint.

# IntelliJ Plugins Installed
- Gauge
- Markdown Navigator
