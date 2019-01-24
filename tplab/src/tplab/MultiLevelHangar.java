package tplab;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class MultiLevelHangar {
	ArrayList<Hangar<ITransport>> hangarStages;
    private  int countPlaces = 15; 
    private int pictureWidth;

 	private int pictureHeight;
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
     
     public boolean saveData(String filename) {
         File file = new File(filename);
         if (file.exists()) {
             file.delete();
         }
         try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
             writeToFile("ParkingStages:" + hangarStages.size() + System.lineSeparator(), bw);
             for (Hangar<ITransport> level :hangarStages) {
                 writeToFile("Level" + System.lineSeparator(), bw);
                 for (int i = 0; i < countPlaces; i++) {
                     ITransport car = level.getAircraft(i);
                     if (car != null) {
                         if (car.getClass().getSimpleName().equals("Aircraft")) {
                             writeToFile(i + ":Aircraft:" + car.toString(), bw);
                         }
                         if (car.getClass().getSimpleName().equals("FighterAircraft")) {
                             writeToFile(i + ":FighterAircraft:" + car.toString(), bw);
                         }
                         writeToFile(System.lineSeparator(), bw);
                     }
                 }
             }
             return true;
         } catch (Exception ex) {
             System.out.println(ex);
             return false;
         }
  }

   private void writeToFile(String text, BufferedWriter writer) {
         try {
             char[] info = text.toCharArray();
             writer.write(info, 0, info.length);
         } catch (Exception e) {
             System.out.println(e);
         }
   }

   public boolean loadData(String filename) {
         File file = new File(filename);
         if (!file.exists()) {
             return false;
         }
         String bufferTextFromFile = "";
         try (BufferedReader br = new BufferedReader(new FileReader(file))) {
             String line;
             while ((line = br.readLine()) != null) {
                 bufferTextFromFile += line + "\n";
             }
             String[] strs = bufferTextFromFile.split("\n");
             if (strs[0].contains("ParkingStages")) {
                 int count = Integer.parseInt(strs[0].split(":")[1]);
                 if (hangarStages != null) {
                 	hangarStages.clear();
                 }
                 hangarStages = new ArrayList<Hangar<ITransport>>(count);
             } else {
                 return false;
             }
             int counter = -1;
             ITransport car = null;
             for (int i = 1; i < strs.length; ++i) {
                 if (strs[i].equals("Level")) {
                     counter++;
                     hangarStages.add(new Hangar<ITransport>(countPlaces, pictureWidth, pictureHeight));
                     continue;
                 }
                 if (strs[i].isEmpty() || strs[i] == null) {
                     continue;
                 }
                 if (strs[i].split(":")[1].equals("Aircraft")) {
                     car = new Aircraft(strs[i].split(":")[2]);
                 } else if (strs[i].split(":")[1].equals("FighterAircraft")) {
                     car = new FighterAircraft(strs[i].split(":")[2]);
                 }
                 hangarStages.get(counter).setAircraft(Integer.parseInt(strs[i].split(":")[0]), car);
             }
             return true;
         } catch (Exception e) {
             System.out.println(e);
         }
         return false;
     }
}
