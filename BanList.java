import java.util.ArrayList;
public class BanList{

private ArrayList<Word> currentlyBanned=new ArrayList<Word>();
private ArrayList<Word> everBanned=new ArrayList<Word>();   
public BanList(){
}

public void banning(String incomingWord){
boolean isNew=true;
Word newWord =new Word(incomingWord);
for (int i=0;i<everBanned.size();i++) if (everBanned.get(i).getWord().equals(incomingWord)) isNew=false;
if (isNew){
  System.out.println(incomingWord+": procced isNew");
addList(newWord,true, incomingWord);
}
else{
System.out.println(incomingWord+": increment");
addList(newWord, false,incomingWord);
}
}

public void addList(Word adding, boolean isNew, String reBan)
 {
if (isNew)
  {
    everBanned.add(adding);
if (currentlyBanned.size()>9)
   {
// System.out.println("before get");
currentlyBanned.get(0).earlyRemove();
// System.out.println("before removed");
currentlyBanned.remove(0);
 //System.out.println("before added");
currentlyBanned.add(adding);
   }
   else
   {
   System.out.println("adding less than 9");
currentlyBanned.add(adding);
   }
  }
else
 {
  boolean found=false;
  for (int i=0;i<currentlyBanned.size();i++){
  if (adding.getWord().equals(currentlyBanned.get(i).getWord()))
    {
      currentlyBanned.get(i).earlyRemove();
      currentlyBanned.remove(i);
      currentlyBanned.add(adding);
      currentlyBanned.get(currentlyBanned.size()-1).ban();
      found=true;
    }
   }
   if (!(found))
   {
    if (currentlyBanned.size()>9)
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
for (int i=0;i<currentlyBanned.size();i++){
    currentlyBanned.get(i).dayPass();
    if (currentlyBanned.get(i).doRemove()){
    currentlyBanned.get(i).earlyRemove();
    currentlyBanned.remove(i);
    i--;
    }
}
}

public String current(){
String ret="";
for (int i=0;i<currentlyBanned.size();i++){
  ret+=currentlyBanned.get(i).wordData();
  if (i<currentlyBanned.size()-1&&currentlyBanned.size()>0) ret+=" ";
}
return ret;
}

public String ever(){
  String ret="";
for (int i=0;i<everBanned.size();i++){
  ret+=everBanned.get(i).wordData();
  if (i<everBanned.size()-1&&everBanned.size()>0) ret+=" ";
}
return ret;
}
public String toString(){
  String ret="\n"+"Currently Banned";
  ret+="\n";
for (int i=0;i<currentlyBanned.size();i++){
  ret+=currentlyBanned.get(i);
  if (i<currentlyBanned.size()-1&&currentlyBanned.size()>0) ret+=" ";
}
ret+="\n";
ret+="\n";
ret+="Ever Banned";
ret+="\n";
for (int i=0;i<everBanned.size();i++){
  ret+=everBanned.get(i);
  if (i<everBanned.size()-1&&everBanned.size()>0) ret+=" ";
}
return ret;
}


}