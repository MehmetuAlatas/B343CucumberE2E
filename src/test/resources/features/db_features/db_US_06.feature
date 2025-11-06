
Feature: Database testleri
  Scenario: Kategori isimlerinin boş olmadığını kontrol et
    Given Database'e baglan
    When category_entity tablosundaki tüm kayıtları al
    Then name sutunu boş olmamalıdır