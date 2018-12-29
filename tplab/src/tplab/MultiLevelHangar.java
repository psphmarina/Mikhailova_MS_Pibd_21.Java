package tplab;

import java.util.ArrayList;

public class MultiLevelHangar {
	ArrayList<Hangar<ITransport>> hangarStages;
    private  int countPlaces = 15; 
    public MultiLevelHangar(int countStages, int pictureWidth, int pictureHeight)
    {
        hangarStages = new ArrayList<Hangar<ITransport>>();
        for(int i =0; i< countStages; ++i)
        {
            hangarStages.add(new Hangar<ITransport>(countPlaces, pictureWidth, pictureHeight));
        }
    }
   
     public Hangar<ITransport> getHangar(int ind){
   	 if((ind>-1) && (ind < hangarStages.size()))
        {
            return hangarStages.get(ind);
        }
        return null;
    }
}
