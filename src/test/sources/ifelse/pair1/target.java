public int get(int key) {
    if(lfuCache.get(key)==null)
        return -1;
    Node v=lfuCache.get(key);
    freqList.get(v.freq).removeNode(v);
    if(freqList.get(v.freq).isEmpty()){
        if(minFreq==v.freq){
            minFreq=v.freq+1;
        }
    }
    v.freq+=1;
    if(freqList.get(v.freq)==null){
        DoublyLinkedList d=new DoublyLinkedList();
        d.addNode(v);
        freqList.put(v.freq,d);
    }
    else{
        freqList.get(v.freq).addNode(v);
    }
    return v.val;
}
