package org.example;

import org.example.dto.Company;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

//@EnableDiscoveryClient
@SpringBootApplication
public class CompanyServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompanyServiceApplication.class, args);
    }


    @Bean
    public List<Company> companyList() {
        List<String> companyNameList = Arrays.asList("Accenture", "Mphasis", "Genpact", "Infosys", "CGI");
        List<Company> companyList = new ArrayList<>();
        int[] arr = IntStream.rangeClosed(100, 110).toArray();
        List<List<Integer>> numberList = IntStream.iterate(0, i -> i + 2).boxed()
                .map(j -> Arrays.asList(arr[j], arr[j + 1])).limit(5).toList();
        for (int i = 0; i < numberList.size(); i++) {
            Company company = Company.builder().compName(companyNameList.get(i)).employeeIds(numberList.get(i)).build();
            companyList.add(company);
        }
        return companyList;
    }
}
