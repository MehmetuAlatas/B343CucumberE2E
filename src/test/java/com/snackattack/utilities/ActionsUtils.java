package com.snackattack.utilities;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsUtils {

    /**
     * Belirtilen element üzerinde sağ tıklama (context click) işlemi yapar.
     *
     * @param element Sağ tıklama yapılacak WebElement.
     */
    public static void rightClick(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());  // Her metodda yeni bir Actions nesnesi oluşturuluyor
        actions.contextClick(element).perform();
    }

    /**
     * Belirtilen element üzerinde çift tıklama işlemi yapar.
     *
     * @param element Çift tıklama yapılacak WebElement.
     */
    public static void doubleClick(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());  // Her metodda yeni bir Actions nesnesi oluşturuluyor
        actions.doubleClick(element).build().perform();
    }

    /**
     * Belirtilen element üzerinde fare ile üzerine gelme (hover) işlemi yapar.
     *
     * @param element Üzerine gelinmesi istenen WebElement.
     */
    public static void hoverOver(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());  // Her metodda yeni bir Actions nesnesi oluşturuluyor
        actions.moveToElement(element).perform();
    }

    /**
     * Sayfayı PAGE_DOWN tuşu ile aşağı kaydırır.
     */
    public static void scrollDown() {
        Actions actions = new Actions(Driver.getDriver());  // Her metodda yeni bir Actions nesnesi oluşturuluyor
        actions.sendKeys(Keys.PAGE_DOWN).perform();
    }

    /**
     * Sayfayı PAGE_UP tuşu ile yukarı kaydırır.
     */
    public static void scrollUp() {
        Actions actions = new Actions(Driver.getDriver());  // Her metodda yeni bir Actions nesnesi oluşturuluyor
        actions.sendKeys(Keys.PAGE_UP).perform();
    }

    /**
     * Sayfayı ARROW_RIGHT tuşu ile sağa kaydırır.
     */
    public static void scrollRight() {
        Actions actions = new Actions(Driver.getDriver());  // Her metodda yeni bir Actions nesnesi oluşturuluyor
        actions.sendKeys(Keys.ARROW_RIGHT, Keys.ARROW_RIGHT).perform();
    }

    /**
     * Sayfayı ARROW_LEFT tuşu ile sola kaydırır.
     */
    public static void scrollLeft() {
        Actions actions = new Actions(Driver.getDriver());  // Her metodda yeni bir Actions nesnesi oluşturuluyor
        actions.sendKeys(Keys.ARROW_LEFT, Keys.ARROW_LEFT).perform();
    }

    /**
     * Sayfayı HOME tuşu ile en üste kaydırır.
     */
    public static void scrollHome() {
        Actions actions = new Actions(Driver.getDriver());  // Her metodda yeni bir Actions nesnesi oluşturuluyor
        actions.sendKeys(Keys.HOME).perform();
    }

    /**
     * Sayfayı END tuşu ile en alta kaydırır.
     */
    public static void scrollEnd() {
        Actions actions = new Actions(Driver.getDriver());  // Her metodda yeni bir Actions nesnesi oluşturuluyor
        actions.sendKeys(Keys.END).perform();
    }

    /**
     * Kaynak elementi hedef elemente sürükleyip bırakır.
     *
     * @param source Sürüklenmek istenen WebElement.
     * @param target Bırakılmak istenen WebElement.
     */
    public static void dragAndDrop(WebElement source, WebElement target) {
        Actions actions = new Actions(Driver.getDriver());  // Her metodda yeni bir Actions nesnesi oluşturuluyor
        actions.dragAndDrop(source, target).perform();
    }

    /**
     * Kaynak elementi belirtilen mesafe kadar yatay (x) ve dikey (y) yönde sürükler.
     *
     * @param source  Sürüklenmek istenen WebElement.
     * @param xOffset Yatay eksende sürüklenme mesafesi (pozitif sağa, negatif sola).
     * @param yOffset Dikey eksende sürüklenme mesafesi (pozitif aşağı, negatif yukarı).
     */
    public static void dragAndDropBy(WebElement source, int xOffset, int yOffset) {
        Actions actions = new Actions(Driver.getDriver());  // Her metodda yeni bir Actions nesnesi oluşturuluyor
        actions.dragAndDropBy(source, xOffset, yOffset).perform();
    }

    /**
     * TAB tuşuna basarak elementler arası geçiş yapmayı sağlar.
     */
    public static void pressTab() {
        Actions actions = new Actions(Driver.getDriver());  // Her metodda yeni bir Actions nesnesi oluşturuluyor
        actions.sendKeys(Keys.TAB).build().perform();
    }

    /**
     * Aşağı yön tuşuna basar.
     */
    public static void pressArrowDown() {
        Actions actions = new Actions(Driver.getDriver());  // Her metodda yeni bir Actions nesnesi oluşturuluyor
        actions.sendKeys(Keys.ARROW_DOWN).build().perform();
    }

    /**
     * Enter tuşuna basar.
     */
    public static void pressEnter() {
        Actions actions = new Actions(Driver.getDriver());  // Her metodda yeni bir Actions nesnesi oluşturuluyor
        actions.sendKeys(Keys.ENTER).build().perform();
    }
}
