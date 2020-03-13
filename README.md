# JavaFXTools
JavaFX custom tools to help building different Apps and Games



#### repositories:

    mavenCentral()  
    maven { url 'https://jitpack.io' }  

#### dependencies:

    implementation 'com.github.alidali96:JavaFXTools:v0.1'


### Example


    HBoxContainer container = new HBoxContainer(10);  
    container.setAlignment(Pos.CENTER);  
 
    Label fName = new Label("Ali");  
    Label lName = new Label("Dali");  
    fName.setPadding(new Insets(10));  
    lName.setPadding(new Insets(10));  
    Button button = new Button("Button");  

    container.addChildren(fName, lName, button);
