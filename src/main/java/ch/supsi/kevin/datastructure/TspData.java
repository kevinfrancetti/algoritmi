package ch.supsi.kevin.datastructure;

import java.util.List;

public class TspData {
    float[] data;

    public TspData(float[] data){
        this.data = data;
    }

    public TspData(List<Float> data){
        this.data = new float[data.size()];
        for(int i = 0; i < this.data.length; i++){
            this.data[i] = data.get(i);
        }
    }

    public void printData(){
        for(int i = 0; i < data.length; i++){
            System.out.print(data[i] + " ");
        }
    }

}
