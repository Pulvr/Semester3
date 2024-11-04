package org.unittest.paydude;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class PayDudeTest {

    @Test
    void testDepositAndInstance() {
        PayDude dude = new PayDude();
        dude.deposit(30);

        assertInstanceOf(PayDude.class, dude);
        assertEquals(30,dude.getBalance());
    }

    @Test
    void depositNegativeMoneyTest(){
        PayDude dude = new PayDude();
        assertThrows(PayDudeException.class,()->dude.deposit(-30) );
    }

    @Test
    void depositTooMuchMoneyTest(){
        PayDude dude = new PayDude();
        dude.deposit(9223372036854775807L);
        dude.deposit(1);
        assertEquals(-9223372036854775808L,dude.getBalance());
    }

    @Test
    void transferTest() {
        PayDude sender = new PayDude();
        PayDude recipient = new PayDude();

        sender.deposit(30);
        sender.transfer(30,recipient);

        assertEquals(0,sender.getBalance());
        assertEquals(30,recipient.getBalance());
    }

    @Test
    void transferLessMoneyTest(){
        PayDude sender = new PayDude();
        PayDude recipient = new PayDude();

        sender.deposit(30);
        //Exception zwischenspeichern und Message Wert vergleichen
        PayDudeException exception = assertThrows(PayDudeException.class, () -> sender.transfer(31,recipient));
        assertEquals("Go get some money, dude.",exception.getMessage());
    }

    @Test
    void transferNegativeMoneyTest(){
        PayDude sender = new PayDude();
        PayDude recipient = new PayDude();

        sender.deposit(30);

        PayDudeException exception = assertThrows(PayDudeException.class, ()-> sender.transfer(-30,recipient));
        assertEquals("Negative amounts are not allowed.", exception.getMessage());
    }

    @Test
    void getBalanceTest() {
        PayDude dude = new PayDude();
        assertEquals(0,dude.getBalance());
    }
}