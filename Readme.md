# Little 2D Game in java : demo

## Project setup and configuration

### Sections

- [**Java stuff**](#Installing-Java-stuff)
- [**IntelliJ**](#IntelliJ)
- [**Trello project board**](#Trello-project-board)

---

## Java stuff

You have to install Java Runtime Environment and Java Develpment Kit.


1. [JRE 1.8](https://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html)
2. [JDK 1.8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)


---

## IntelliJ

1. You have to install IntelliJ Community version, preferably v. 2019.2.2 :
[Install IntelliJ](https://www.jetbrains.com/idea/download/#section=windows)

2. Open project using IntelliJ and hit ctrl + alt + shift +s. **Project Structure** menu will appear.

3. Under **Project Settings** section go to **Project** and change the following to : 
    - Project SDK : 1.8 (java version "1.8.0_211")
    - Project language level "8 - lambdas, type annotations etc."
    - Project compiler output "C:\path_to_project_folder\out"

4. Under **Project Settings** section go to **Modules** and make changes as follows:
    - On the right side of the window hit the **Sources** bookmark
    - Mark "*src*" folder as **Sources Folders**,
    - Mark "*resources*" folder as **Resources Folders**

5. Hit the **Apply** button.

6. Build the project : ctrl + F9.

7. At the top bar menu go to **Run** bookmark and hit **Edit configurations**:
    - Hit "**+**" plus button : "**Add New Configuration**" : **Application**
    - **Name** it : Little2DGame ;]
    - In **Main class** add : "dev.codenmore.java2Dgame.Launcher"
    - **Working directory** : "C:\path_to_project_folder"
    - **Use classpath of module** : Little2DGame

8. Hit the **Apply** button.

9. You are ready to **Run** : shift + F10.
---

## Trello project board

- Link to Trello project features board : [Trello project features](https://trello.com/b/sX3Kb6dl/little-java-game-development)
- Link to Trello bugs and fixes board : [Trello bugs and fixes](https://trello.com/b/11dnnJxm/sugestions-bugs)