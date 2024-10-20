package com.tahagasht.hotel.ejb.service;

import com.tahagasht.hotel.ejb.dao.HotelBookingDao;
import com.tahagasht.hotel.ejb.dto.BookingMatchWithHotelDto;
import com.tahagasht.hotel.ejb.dto.HotelBookingDtoManager;
import com.tahagasht.hotel.ejb.dto.HotelDtoManager;
import com.tahagasht.hotel.ejb.model.HotelBooking;
import com.tahagasht.hotel.ejb.dto.SearchHotelModel;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateful;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.Setter;
import org.mapstruct.factory.Mappers;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;

@Stateless
@LocalBean
public class BookingComService {

    @Inject
    private HotelBookingDao hotelBookingDao;
    @Getter
    Set<SearchHotelModel> searchHotelModels = new HashSet<>();

    private HotelBookingDtoManager hotelBookingDtoManager = Mappers.getMapper(HotelBookingDtoManager.class);

    Set<WebElement> eleName = new HashSet<>();

    public void findHotelDetail(String hotelName , String url,String cityName,String countryCode) throws InterruptedException {
        //System.setProperty("webdriver.gecko.driver", "D:\\geckodriver-v0.34.0-win64\\geckodriver.exe");
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        FirefoxDriver firefoxDriver = new FirefoxDriver();
        try {
            String hotelNameIn = hotelName.replace(" ", "-").toLowerCase();
            firefoxDriver.get(url);
            Thread.sleep(2000);
            WebElement facility = firefoxDriver.findElement(By.id("hp_facilities_box"));
            String fac = facility.getText();
            Thread.sleep(2000);
            List<WebElement> descriptionElem = firefoxDriver.findElements(By.className("hp-description"));
            String description = descriptionElem.get(0).getText();
            Thread.sleep(2000);
            Double lat = null;
            Double lng = null;
            try {
                String latlong = firefoxDriver.findElement(By.id("hotel_sidebar_static_map_capla")).getAttribute("data-atlas-latlng");
                lat = Double.valueOf(latlong.substring(0, latlong.indexOf(",")));
                lng = Double.valueOf(latlong.substring(latlong.indexOf(",") + 1, latlong.length()));
            } catch (Exception e) {
                String latlong = firefoxDriver.findElement(By.id("hotel_sidebar_static_map")).getAttribute("data-atlas-latlng");
                lat = Double.valueOf(latlong.substring(0, latlong.indexOf(",")));
                lng = Double.valueOf(latlong.substring(latlong.indexOf(",") + 1, latlong.length()));
            }
            Thread.sleep(2000);
            try {
                List<WebElement> inputBody = firefoxDriver.findElements(By.className("bh-photo-grid-item"));
                inputBody.get(0).sendKeys(Keys.ENTER);
            } catch (Exception e) {
                List<WebElement> inputBody = firefoxDriver.findElements(By.tagName("picture"));
                inputBody.get(1).findElement(By.tagName("img")).click();
            }
            Thread.sleep(4000);
            List<WebElement> ele = firefoxDriver.findElements(By.tagName("img"));
            HotelBooking hotelBooking = new HotelBooking();
            hotelBooking.setHotelName(hotelName);
            hotelBooking.setFicility(fac);
            hotelBooking.setLat(lat);
            hotelBooking.setLng(lng);
            hotelBooking.setCityName(cityName);
            hotelBooking.setCountryCode(countryCode);
            hotelBooking.setDescription(description);
            hotelBookingDao.save(hotelBooking);
            Thread.sleep(5000);
            try {

                Path path = Paths.get("D:\\booking\\" + hotelNameIn);

                Files.createDirectories(path);

                System.out.println("Directory is created!");

                //Files.createDirectory(path);

            } catch (IOException e) {
                System.err.println("Failed to create directory!" + e.getMessage());
            }
            int p = 0;
            for (WebElement o : ele) {
                try {
                    Thread.sleep(500);
                    URL url2 = new URL(o.getAttribute("src"));
                    InputStream in = new BufferedInputStream(url2.openStream());
                    ByteArrayOutputStream out = new ByteArrayOutputStream();
                    if (url2.getPath().toLowerCase().contains("max1024".toLowerCase())) {
                        byte[] buf = new byte[1024];
                        int n = 0;
                        while (-1 != (n = in.read(buf))) {
                            out.write(buf, 0, n);
                        }
                        byte[] response = out.toByteArray();
                        FileOutputStream fos = new FileOutputStream("D:\\booking\\" + hotelNameIn + "\\" + p + ".jpg");
                        fos.write(response);
                        fos.close();
                        p++;
                    }
                    out.close();
                    in.close();
                } catch (Exception e) {
                    System.out.println("END");
                }
            }
            firefoxDriver.quit();
        }catch (Exception e){
            e.printStackTrace();
            firefoxDriver.quit();
        }
    }

    public Set<SearchHotelModel> findHotelsByCity(String cityName, String countryCode) {
        System.setProperty("webdriver.gecko.driver","geckodriver.exe");
        FirefoxDriver firefoxDriver = new FirefoxDriver();
        firefoxDriver.get("https://www.booking.com/searchresults.html?ss="+cityName+"&checkin=2024-07-04&checkout=2024-07-05&group_adults=1&no_rooms=1&group_children=0");
        try{
        Thread.sleep(2000);
        //Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) firefoxDriver;
        js.executeScript("window.scrollBy(0,1000250)", "");
        Thread.sleep(5000);
        js.executeScript("window.scrollBy(0,1000250)", "");
        Thread.sleep(5000);
        js.executeScript("window.scrollBy(0,1000250)", "");
        Thread.sleep(2000);
        WebElement inputBody = firefoxDriver.findElement(By.tagName("body"));
        Thread.sleep(5000);
        inputBody.sendKeys(Keys.ENTER);

        while (true) {
            List<WebElement> ele = firefoxDriver.findElements(By.tagName("button"));
            WebElement loadmore = null;
            int countElem=0;
            for (WebElement el : ele) {
                countElem++;
                try {
                    System.out.println(el.findElement(By.tagName("span")).getText());
                    /// WebElement elSel = el.findElement(By.tagName("span"));
                    if(countElem==1) {
                        eleName.addAll(firefoxDriver.findElements(By.tagName("a")));
                        long h = 0;
                        for (WebElement p : eleName) {
                            h++;
                            try {
                                SearchHotelModel searchHotelModel = new SearchHotelModel();
                                String text = p.findElement(By.tagName("div")).getText();
                                if (text.contains("reviews")
                                        || text.equals("")) {
                                    continue;
                                    //stringList.add(p.findElement(By.tagName("div")).getText());
                                }
                                if(searchHotelModels.stream().filter(f->f.getName().equals(text)).count()<1) {
                                    String url = p.getAttribute("href");
                                    searchHotelModel.setId(h);
                                    searchHotelModel.setName(text);
                                    searchHotelModel.setCityCode(cityName);
                                    searchHotelModel.setCountryCode(countryCode);
                                    searchHotelModel.setUrl(url);
                                    searchHotelModels.add(searchHotelModel);
                                }
/*                if(p.findElement(By.tagName("div")).getText().equals("NAREMA FAMILY HOTEL MEGHRI"))
                    p.sendKeys(Keys.ENTER);*/
                            } catch (Exception e) {
                                // e.printStackTrace();
                            }
                        }
                    }

                    if (el.findElement(By.tagName("span")).getText().equals("Load more results")) {
                        loadmore = el;
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("errrr");
                }
            }
            if(loadmore==null){
                break;
            }
            loadmore.sendKeys(Keys.ENTER);
            js.executeScript("window.scrollBy(0,2000250)", "");
            Thread.sleep(5000);
        }

        //List<WebElement> eleName = firefoxDriver.findElements(By.tagName("a"));

        firefoxDriver.quit();
        return searchHotelModels;
        }catch (Exception e){
            firefoxDriver.quit();
            return searchHotelModels;
        }

    }

    public HotelBooking findHotelBookingByName(String hotelName) throws Exception {
        return hotelBookingDao.findHotelBookingByName(hotelName).get();
    }


    public List<BookingMatchWithHotelDto> findBookingMatchWithHotelDtos()
    {
        hotelBookingDao.findHotelBookingMatch();
        return null;
    }
}
