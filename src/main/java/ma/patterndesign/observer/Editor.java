package ma.patterndesign.observer;

import java.io.File;

public class Editor {

    public EventManager eventJ;
    public File file;

    public Editor(){
        eventJ = new EventManager("open","save");
    }

    public void openFile(String FilePath){
        this.file = new File(FilePath);
        eventJ.notify("open",file);
    }

    public void saveFile() throws Exception{
        if (this.file != null) {
            eventJ.notify("save",file);
        }else {
            throw new Exception("Please open file first!!");
        }
    }



}
