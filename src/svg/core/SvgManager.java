package svg.core;

import Shapes.Shape;
import java.util.ArrayList;
import java.util.List;
import io.SvgWriter;

public class SvgManager {
    private static SvgManager instance;
    private List<Shape> shapes = new ArrayList<>();
    private String filePath;

    private SvgManager() {}

    public static SvgManager getInstance(){
        if(instance == null) {
            instance = new SvgManager();
        }
        //System.out.println("DEBUG: SvgManager instance hash = " + instance.hashCode());
        return instance;
    }

    public void load(List<Shape> shapesFromFile, String filePath){
        this.shapes = shapesFromFile;
        this.filePath = filePath;
    }

    public void save(){
        SvgWriter.write(filePath, shapes);
    }

    public void saveAS(String newPath){
        this.filePath = newPath;
        save();
    }

    public boolean erase(int index){
        if(index < 1 || index > shapes.size()){
            return false;
        }
        shapes.remove(index - 1);
        return true;
    }
    public void clear(){
        shapes.clear();
        filePath = null;
    }
    public boolean hasOpenFile() {
        return filePath != null && !filePath.isEmpty();
    }
    public boolean translateOne(int index, int dx, int dy){
        if(index < 1 || index > shapes.size()){
            return false;
        }
        shapes.get(index - 1).translate(dx,dy);
        return true;
    }
    public void printShapes(){
        int i = 1;
        for(Shape shape: shapes){
            System.out.printf("%d. %s%n", i++, shape.toText());
        }
    }
    public List<Shape> getShapes(){
        return shapes;
    }
    public String getFilePath(){
        return filePath;
    }

}
