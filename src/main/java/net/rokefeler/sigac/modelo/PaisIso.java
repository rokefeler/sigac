package net.rokefeler.sigac.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Jose Roque el 09/08/2015.
 * Email: rokefeler@gmail.com
 */
@Entity(name="tpaisiso")
public class PaisIso implements Serializable{
    private String id;
    private String countryISOA2;
    private String countryISON3;
    private String countryNameES;
    private String countryNameEN;
    private String continent;
    private String phoneCode;
    private String languageCode;
    private String locales;
    private String currency;
    private String capital;
    private BigDecimal latitude;
    private BigDecimal longitude;

    @Id
    @Column(name="id_PaisIso", nullable = false, length= 3)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name="countryISO_A2_PaisIso", nullable = false, length= 2)
    public String getCountryISOA2() {
        return countryISOA2;
    }

    public void setCountryISOA2(String countryISOA2) {
        this.countryISOA2 = countryISOA2;
    }

    @Column(name="countryISO_N3_PaisIso", nullable = false, length= 3)
    public String getCountryISON3() {
        return countryISON3;
    }

    public void setCountryISON3(String countryISON3) {
        this.countryISON3 = countryISON3;
    }

    @Column(name="countryNameES_PaisIso", nullable = false, length= 85)
    public String getCountryNameES() {
        return countryNameES;
    }

    public void setCountryNameES(String countryNameES) {
        this.countryNameES = countryNameES;
    }

    @Column(name="countryNameEN_PaisIso", nullable = true, length= 85)
    public String getCountryNameEN() {
        return countryNameEN;
    }

    public void setCountryNameEN(String countryNameEN) {
        this.countryNameEN = countryNameEN;
    }

    @Column(name="continent_PaisIso", nullable = true, length= 2)
    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    @Column(name="phoneCode_PaisIso", nullable = true, length= 8)
    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    @Column(name="languageCode_PaisIso", nullable = true, length= 2)
    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    @Column(name="locales_PaisIso", nullable = true, length= 75)
    public String getLocales() {
        return locales;
    }

    public void setLocales(String locales) {
        this.locales = locales;
    }

    @Column(name="currency_PaisIso", nullable = true, length= 3)
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Column(name="capital_PaisIso", nullable = true, length= 44)
    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    @Column(name="latitude_PaisIso", nullable = true, length= 18, precision = 6)
    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    @Column(name="longitude_PaisIso", nullable = true, length= 18, precision = 6)
    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PaisIso paisIso = (PaisIso) o;

        if (!id.equals(paisIso.id)) return false;
        if (!countryISOA2.equals(paisIso.countryISOA2)) return false;
        if (!countryISON3.equals(paisIso.countryISON3)) return false;
        if (!countryNameES.equals(paisIso.countryNameES)) return false;
        if (!countryNameEN.equals(paisIso.countryNameEN)) return false;
        if (!continent.equals(paisIso.continent)) return false;
        if (!phoneCode.equals(paisIso.phoneCode)) return false;
        if (!languageCode.equals(paisIso.languageCode)) return false;
        if (!locales.equals(paisIso.locales)) return false;
        if (!currency.equals(paisIso.currency)) return false;
        if (!capital.equals(paisIso.capital)) return false;
        if (latitude != null ? !latitude.equals(paisIso.latitude) : paisIso.latitude != null) return false;
        return !(longitude != null ? !longitude.equals(paisIso.longitude) : paisIso.longitude != null);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
