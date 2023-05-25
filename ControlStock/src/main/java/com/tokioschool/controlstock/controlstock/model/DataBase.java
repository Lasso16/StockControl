package com.tokioschool.controlstock.controlstock.model;


import com.tokioschool.controlstock.controlstock.domain.Item;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class DataBase {
    private final String dbFile = "src/main/resources/db.csv";
    private Set<Item> itemList;

    public DataBase() {
        itemList = new HashSet<>();
        readDb();
    }

    private void readDb() {
        if (!Files.exists(Paths.get(dbFile))) {
            try {
                Files.createFile(Paths.get(dbFile));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (Reader reader = Files.newBufferedReader(Paths.get(dbFile));
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withDelimiter(';'))) {
            for (CSVRecord csvRecord : csvParser) {
                    itemList.add(new Item(Integer.parseInt(csvRecord.get(0)), csvRecord.get(1), Integer.parseInt(csvRecord.get(2))));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addItem(Item item) {

        try {
            BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(dbFile), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
            CSVPrinter csvPrinter = new CSVPrinter(bufferedWriter, CSVFormat.newFormat(';')
                    .withRecordSeparator("\n"));

            csvPrinter.printRecord(item.getID(), item.getName(), item.getStock());
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        itemList.add(item);

    }

    public int setID() {
        Random rd = new Random();
        boolean found = false;

        int id = rd.nextInt(89999) + 10000;
        for (Item i : getItemList()) {
            if (i.getID() == id)
                found = true;
        }
        if (!found)
            return id;
        else
            return setID();
    }

    public String getDbFile() {
        return dbFile;
    }

    public Set<Item> getItemList() {
        return itemList;
    }
}
