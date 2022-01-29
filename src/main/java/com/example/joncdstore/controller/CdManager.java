package com.example.joncdstore.controller;

import com.example.joncdstore.model.CD;

import java.io.*;
import java.util.*;

public class CdManager implements Serializable {

    private ArrayList<CD> cdList;

    public CdManager() {
    }

    public void addCd(ArrayList<CD> c) {
        try {
            cdList = c;
            FileOutputStream f1 = new FileOutputStream("cd.ser",true);
            BufferedOutputStream f2 = new BufferedOutputStream(f1);
            ObjectOutputStream outObject = new ObjectOutputStream(f2);

            outObject.writeObject(cdList);

            f2.close();
            outObject.close();

        } catch (IOException e) {
            System.out.println("Add CD unsuccessful!\n" + e);
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

            for (CD c : cdList) {
                System.out.println(c.toString());
            }


        } catch (ClassNotFoundException i) {
            System.out.println("CDs cannot be found!\n" + i);
        } catch (IOException e) {
            System.out.println("Reading supply unsuccessful!\n" + e);
        }
    }


    public void checkQuantity() {

        int minQuantity = 5;
        readCD();

        Set<String> genreSet = createGenreSet(cdList);
        Map<String, Integer> genreMap = createGenreMap(cdList, genreSet);

        Iterator<Map.Entry<String, Integer>> it = genreMap.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<String, Integer> pair = it.next();

            if (pair.getValue() < minQuantity) {
                System.out.println("Warning! Genre \"" + pair.getKey() + "\" will soon be out of stock");
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
        int numberOfCD = 0;

        for (String i : genreSet) {
            numberOfCD = 0;
            for (CD j : cdList) {
                if (Objects.equals(i, j.getGenre())) {
                    numberOfCD += j.getQuantityOfCD();
                }
            }
            System.out.println(numberOfCD);
            genreMap.put(i, numberOfCD);
        }
        System.out.println(genreMap);
        return genreMap;
    }
}
