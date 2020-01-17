package main.patterns.constants;

public class Surnames {

    private String[] Surnames = {"Bayntun", "Beacham", "Beadon", "Artley", "Asbridge", "Ashbee", "Allitt", "Allred",
            "Allum", "Blackett", "Blackett-Ord", "Blackman", "Blackmon", "Blair", "Blake", "Ashley-Cooper", "Asplin",
            "Assheton"};


    public String getName(final Integer index) {
        return Surnames[index];
    }

    public Integer getSize() {
        return Surnames.length;
    }

}
