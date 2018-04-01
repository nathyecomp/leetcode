/*
https://leetcode.com/problems/lru-cache/description/
LinkedHashMap tem operacoes O(1) assim como a HashMap. A vantagem é que armazena em ordem de insercao, ao contrario
da HashMap. Porém, se um numero for atualizado, ela mantém a ordem inicial. Por isso, que é preciso
sempre deletar e adicionar esse número de novo. Essa ordem facilita o removeFirst da lista, mas nao sei se esse procedimento
de criar iterator e remover first é O(N)....*/
class LRUCache {

    LinkedHashMap<Integer,Integer> keys = new LinkedHashMap<>();
    int c;
    
    public LRUCache(int capacity) {
        c = capacity;
    }
    
    public int get(int key) {
        if(keys.containsKey(key)) {
            int v = keys.remove(key);
            keys.put(key,v);
            return v;
        }
    else return -1;
    }
    
    public void put(int key, int value) {
        if(keys.containsKey(key)){ 
          keys.remove(key);
          keys.put(key,value);
        }
        else{
          if(keys.size()>=c){
              removeLeast();
            }
            keys.put(key,value);
        }

    }
    public void removeLeast(){
      Iterator<Integer> it = keys.keySet().iterator();
        int i = it.next();
        it.remove();
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */