class HashMap<K,V>{
    Pair<K,V>[]map;
    int []bit;
    int capacity=0,cnt=0;
    HashMap(int capacity){
        this.capacity=capacity;
        map=new Pair[capacity];
        for(int i=0;i<capacity;i++) map[i]=null;
        bit=new int[capacity];
    }
    public int hash(K key){
        return (int)key%capacity;
    }
    public void put(K key,V value){
        int home=hash(key);
        int i=findPos(home,key);
        if(i!=-1){
        if(map[i]==null){
            Pair p=new Pair(key,value);
            map[i]=p;
            bit[i]=1;
        }
        else{
            map[i].setValue(value);
        }
        cnt++;
        }
        else{
            System.out.println("cannot be placed");
        }
    }
    public int size(){
        return cnt;
    }
    public V remove(K key){
        int home=hash(key);
        int i=findPos(home,key);
        if(i==-1 || bit[i]==0) return null;
        V val=null;
        if(map[i]!=null && map[i].getKey().equals(key)){
            val=map[i].getValue();
            map[i]=null;
            cnt--;
        }
        return val;
    }
   
    public V get(K key){
        int home=hash(key);
        int i=findPos(home,key);
        if(i==-1|| bit[i]==0 ) return null;
        if(map[i]!=null && map[i].getKey().equals(key)) return map[i].getValue();
        return null;
    }
    public int findPos(int home,K key){
        int i=home,j=1;
        do{
            if(bit[i]==0 || (map[i]!=null && map[i].getKey().equals(key))) return i;
            i=(home+(j*j))%capacity;
            j++;
        }while(i!=home);
        return -1;
    }
    public String toString(){
        String res="";
        for(int i=0;i<capacity;i++){
            if(map[i]!=null) res+=i+" key= "+map[i].getKey()+" value= "+map[i].getValue()+"\n";
        }
        return res;
    }
     public boolean empty(){
        return cnt==0;
    }
}