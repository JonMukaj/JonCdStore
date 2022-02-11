package com.example.joncdstore.model;

import com.example.joncdstore.controller.MenuController;
import javafx.stage.Stage;

import java.io.*;
import java.util.*;


public class CdManager implements Serializable {

    private static final long serialVersionUID = 5847752050191274623L;

    private ArrayList<CD> cdList = new ArrayList<>();
    private final String type;

    public CdManager(String type) {
        this.type = type;
    }

    public void addCd() {
        try {
            FileOutputStream f1 = new FileOutputStream("cd.ser");
            BufferedOutputStream f2 = new BufferedOutputStream(f1);
            ObjectOutputStream outObject = new ObjectOutputStream(f2);

            outObject.writeObject(cdList);

            f2.close();
            outObject.close();

        } catch (IOException e) {
            //System.out.println("Add CDs unsuccessful!\n" + e);
        }
    }

    public void readCD() {
        try {
            FileInputStream f1 = new FileInputStream("cd.ser");
            BufferedInputStream f2 = new BufferedInputStream(f1);
            ObjectInputStream inObject = new ObjectInputStream(f2);

            cdList = (ArrayList<CD>) inObject.readObject();

            f1.close();
            f2.close();
            inObject.close();

            /*for (CD c : cdList) {
                System.out.println(c.toString(type));
            }*/


        } catch (ClassNotFoundException i) {
            //System.out.println("CDs cannot be found!\n" + i);
        } catch (IOException e) {
            addCd();
            //System.out.println("Reading CDs unsuccessful!\n" + e);
        }
    }


    public void checkQuantity(Stage stage) {

        final int minQuantity = 5;
        readCD();

        Set<String> genreSet = createGenreSet(cdList);
        Map<String, Integer> genreMap = createGenreMap(cdList, genreSet);

        for (Map.Entry<String, Integer> pair : genreMap.entrySet()) {
            if (pair.getValue() < minQuantity) {
                MenuController.warningForStock(stage, pair.getKey(), pair.getValue());
                //System.out.println("Warning! Genre \"" + pair.getKey() + "\" will soon be out of stock");
            }
        }

    }

    private LinkedHashSet<String> createGenreSet(ArrayList<CD> cdList) {
        LinkedHashSet<String> genreSet = new LinkedHashSet<>();
        for (CD i : cdList) {
            genreSet.add(i.getGenre());
        }
        return genreSet;
    }

    private LinkedHashMap<String, Integer> createGenreMap(ArrayList<CD> cdList, Set<String> genreSet) {
        LinkedHashMap<String, Integer> genreMap = new LinkedHashMap<>();
        int numberOfCD;

        for (String i : genreSet) {
            numberOfCD = 0;
            for (CD j : cdList) {
                if (Objects.equals(i, j.getGenre())) {
                    numberOfCD += j.getTotalQuantity();
                }
            }
            //System.out.println(numberOfCD);
            genreMap.put(i, numberOfCD);
        }
        //System.out.println(genreMap);
        return genreMap;
    }

    public String showCD() {
        StringBuilder text = new StringBuilder();
        for(CD i : cdList) {
            text.append(i.toString(type));
        }
        return text.toString();
    }

    public int checkCD(String cdTitle) {
        int idx = 0;
        for(CD i : cdList) {
            if (i.getTitleOfCd().equals(cdTitle)) {
                //System.out.println("CD FOUND!");
                return idx;
            }
            idx++;
        }
        idx = -1;
        return idx;
    }

    public boolean searchCD(int idx) {
        return cdList.get(idx).getTotalQuantity() > 0;
    }


    public ArrayList<CD> getCdList() {
        return cdList;
    }

    public void setCdList(ArrayList<CD> cdList) {
        this.cdList = cdList;
    }
}
