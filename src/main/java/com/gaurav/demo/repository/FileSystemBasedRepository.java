package com.gaurav.demo.repository;

import com.gaurav.demo.exception.HashNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.*;

@Repository
@Profile("!InMemory")
public class FileSystemBasedRepository implements HashRepository {
    protected File file;
    @Value("${filePath}")
    protected String filePath;

    @PostConstruct
    public void init() {
        file = new File(filePath);
    }

    @Override
    public void put(String hash, String originalMessage) {
        try {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
                bw.write(String.format("%s:%s\n", hash, originalMessage));

            }
        } catch (Exception e) {

            int i = 1;
        }

    }

    @Override
    public String get(String hash) {

        try {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line = null;
                do {
                    line = ((br.readLine()));
                    String[] columns = line.split(":");
                    if (columns[0].equals(hash)) {
                        return columns[1];
                    }
                }
                while (line != null);

            }
        } catch (Exception e) {
            // The following exception must be thrown. We should never come here or escape out if we have checks in place
        }


        throw new HashNotFoundException("Message Not Found");
    }
}
