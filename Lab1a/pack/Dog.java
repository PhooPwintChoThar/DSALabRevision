package Lab1a.pack;

public class Dog {

    Breed breed;
    int w;

    public Dog(Breed b ,int weight){
        breed=b;
        w=weight;

    }

    public Breed getBreed(){
        return breed;
    }

    @Override
    public String toString(){
        StringBuffer s= new StringBuffer();
        s.append("Dog(");
        s.append(breed);
        s.append(" , ");
        s.append(w);
        s.append(")");

        return s.toString();

    }
    
}
