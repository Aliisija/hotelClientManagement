package main.patterns.constants;

public class Names {
    private String[] names = {"Alan", "Albern", "Adler", "Barry", "Bartholomew", "Shannon", "Brent", "Bennett", "Brian", "Calvin",
            "Carrick", "Carlton", "Cedric", "Charles", "Christian", "Claude", "Clayton", "Coleman", "Conrad", "Crosby", "Curt", "Dennis",
            "Derwin", "Drake", "Drew", "Ernest", "Ethen", "Fabian", "Fitzgerald", "Foster", "Frasier", "Freeman", "Garth",
            "George", "Glenn", "Graham", "Grayson", "Griswold", "Hall", "Halsey"};


    public String getName(final Integer index) {
        return names[index];
    }

    public Integer getSize() {
        return names.length;
    }
}
