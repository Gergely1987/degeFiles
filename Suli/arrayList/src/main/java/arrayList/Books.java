package arrayList;

import java.util.ArrayList;
import java.util.List;

public class Books {
    ArrayList<String>books=new ArrayList<>();

    public void addBook(String s){
        this.books.add(s);
    }

    public List<String> getTitles(){
        return books;
    }

    public List<String>findAllByPrefix(String s){
        List<String>newBooks=new ArrayList<>();

        for (int i=0; i<books.size(); i++){
            if(books.get(i).contains(s)){
                newBooks.add(books.get(i));
            }
        }
        System.out.println(newBooks);
        return newBooks;

    }

    public void removeByPrefix(String prefix){
        List<String>konyvek=new ArrayList<>();
        konyvek.add(prefix);
        for (int i =0; i<books.size(); i++){
            if(books.get(i).contains(prefix)){
                books.removeAll(konyvek);
            }
        }


    }


    public static void main(String[] args) {
        Books b=new Books();
        b.addBook("Rettenthetetlen");
        b.addBook("alma");
        b.addBook("Béla");
        b.addBook("alma kávé");
        b.addBook("kávé sajt");
        b.addBook("tolvaj");

        String a="alma";
        System.out.println(b.getTitles());
        b.findAllByPrefix("alma");

        b.removeByPrefix("alm");
        System.out.println(b.getTitles());
    }
}
