import java.util.ArrayList;
public class BanList{

private ArrayList<Word> currentlyBanned=new ArrayList<Word>();
private ArrayList<Word> everBanned=new ArrayList<Word>();   
public BanList(String test){

}

public void banning(String incomingWord){
boolean isNew=true;
Word newWord =new Word(incomingWord);
for (int i=0;i<everBanned.size();i++) if (everBanned.get(i).getWord().equals(incomingWord)) isNew=false;
if (isNew){
addList(newWord,true, incomingWord);
}
else{
newWord.ban();
addList(newWord, false,incomingWord);
}
}

public void addList(Word adding, boolean isNew, String reBan)
 {
if (isNew)
  {
if (currentlyBanned.size()>9)
   {
currentlyBanned.get(0).earlyRemove();
currentlyBanned.remove(0);
currentlyBanned.add(adding);
   }
  }
else
 {
  boolean found=false;
  for (int i=0;i<currentlyBanned.size();i++){
  if (adding.equals(currentlyBanned(i).getWord()))
    {
      currentlyBanned.get(i).earlyRemove();
      currentlyBanned.remove(i);
      currentlyBanned.add(adding);
      found=true;
    }
   }
   if (!(found))
   {
    if (currentList.size()>9)
    {
     currentlyBanned.get(0).earlyRemove();
     currentlyBanned.remove(0);
     currentlyBanned.add(adding);
    }
   }
   for (Word find: everBanned){
    if (find.getWord().equals(reBan)){
        find.ban();
    }
   }
  }
 }

public void passPeriod(){
for (int i=0;i<currentList.size();i++){
    Word current=currentList.get(i);
    current.dayPass;
    if (current.doRemove()){
    current.earlyRemove();
    currentList.remove(i);
    i--;
    }
}
}
}