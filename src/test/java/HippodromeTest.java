import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class HippodromeTest {
    @Test
    public void TestIfNull(){
        assertThrows(IllegalArgumentException.class , ()-> new Hippodrome(null));

    }
    @Test
    public void TestIfNullMessage(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,()-> new Hippodrome(null));
        assertEquals(exception.getMessage(),"Horses cannot be null.");
    }
    @Test
    public void TestIfEmpty(){
        assertThrows(IllegalArgumentException.class,()->new Hippodrome(new ArrayList<>()));
    }
    @Test
    public void TestIfEmptyMessage(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,()->new Hippodrome(new ArrayList<>()));
        assertEquals(exception.getMessage(),"Horses cannot be empty.");
    }
    @Test
    public void TestGetHorses(){
        ArrayList<Horse> strings = new ArrayList<>();
        for (int i = 0;i<30;i++){
            strings.add(new Horse("kek",5,i));
        }
        Hippodrome hippodrome = new Hippodrome(strings);
        assertEquals(hippodrome.getHorses(),strings);


    }
    @Test
    public void TestMove(){
        ArrayList<Horse> horses = new ArrayList<>();
        for (int i = 0;i<50 ;i++) horses.add(Mockito.mock(Horse.class));
        new Hippodrome(horses).move();
        for(Horse horse : horses){
            Mockito.verify(horse).move();
        }
    }
    @Test
    public void TestGetWinner(){
        ArrayList<Horse> horses = new ArrayList<>();
        for (int i = 0;i<11 ;i++) {horses.add(new Horse("kak",1,i));}
        assertSame(horses.get(10),new Hippodrome(horses).getWinner());

    }
        //for(Horse horse : horses){
        //     Mockito.verify();
        //}
    }

