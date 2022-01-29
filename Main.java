class Main{
    public static void main(String[] args){
       HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>(10);
       hm.put(1,10);
       hm.put(2,15);
       hm.put(11,7);
       hm.put(21,4);
       System.out.println("HashTable\n"+hm);
       Integer x=hm.get(11);
       if(x!=null) System.out.println("value of key 11 is "+x);
       x=hm.remove(21);
       if(x!=null) System.out.println("key 21 with value "+x+" is removed");
       System.out.println("HashTable\n"+hm);
       
        
    }
}