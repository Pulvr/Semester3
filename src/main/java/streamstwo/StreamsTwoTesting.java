package streamstwo;


import streamstwo.records.Address;
import streamstwo.records.Artikel;
import streamstwo.records.Person;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsTwoTesting {


    static void taskOdd(){
        final List<Integer> reverseList = List.of(11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1);
        List<Integer> unevenNumbersList = reverseList.stream()
                .filter(x -> x % 2 != 0)
                .toList();
        System.out.println(unevenNumbersList.reversed());
    }

    static List<Integer> taskDuplicates(){
        final List<Integer> listWithDuplicates = List.of(1, 3, 8, 3, 9, 7, 1, 5, 8, 3, 9, 4, 7, 4, 6, 0, 8, 3, 7);

        for (int i = 0; i < listWithDuplicates.size();i++){
            for ( int j = i + 1; j < listWithDuplicates.size();j++){
                if(listWithDuplicates.get(i).equals(listWithDuplicates.get(j))){
                    //Hier würde eine Liste in ein Set umgewandelt und DANN returned werden.
                    //Set<Integer> listAsSet = listWithDuplicates.stream().collect(Collectors.toSet());
                    //listWithoutAnyDuplicates = listAsSet.stream().toList();

                    // DISTINCT Returns a stream consisting of the distinct elements (according to Object. equals(Object)) of this stream
                    return listWithDuplicates.stream().distinct().collect(Collectors.toList());

                }
            }
        }
        System.out.println("Die Liste enthält keine Duplikate");
        return List.of();
    }

    static void cityTask(){
        var persons = Stream.of(
                new Person("Chris", new Address("Mönckebergstraße","Hamburg")),
                new Person("Olaf", new Address("Rathausstraße", "Hamburg")),
                new Person("Angela", new Address("Schillerstraße", "Berlin")),
                new Person("Markus", new Address("Hofbräuhaus", "München")),
                new Person("Annalena", new Address("Hauptstraße", "Berlin"))
        );
        List<String> cities = persons
                .map(person -> person.adress().city())
                .distinct()
                .toList();

        System.out.println(cities);
    }

    static void superMarketTask(){
        var sortiment = List.of(
                new Artikel("Banane", 100, 1.39),
                new Artikel("Tomate", 200, 0.29),
                new Artikel("Gurke", 50, 0.99),
                new Artikel("Apfel", 300, 0.59),
                new Artikel("Aubergine", 10, 2.19));
        int articlesInStock = sortiment
                .stream()
                .map(Artikel::aufLager)
                .reduce(0,Integer::sum);

        double entireStockValue = sortiment
                .stream()
                .mapToDouble(artikel -> artikel.aufLager() * artikel.preis())
                .sum();

        String allArticles = sortiment
                .stream()
                .map(artikel -> artikel.name() +": "+ artikel.preis()*artikel.aufLager()+" Euro\n")
                .collect(Collectors.joining(""));

        System.out.println("Anzahl Artikel auf Lager insgesamt: "+articlesInStock);
        System.out.println("Lagerwert insgesamt: "+entireStockValue+" Euro");
        System.out.println("Lagerwert pro Artikel: \n"+ allArticles);
    }


    public static void main(String[] args) {
        superMarketTask();
    }

}
