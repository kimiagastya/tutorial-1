Module 1 - Coding Standards
Reflection 1
Pertama, saya sudah melakukan penamaan variabel yang jelas, sesuai dengan data yang disimpan sehingga tidak memerlukan komentar untuk menjelaskan variabelnya.
Kedua, saya bisa melihat dari aspek penulisan komentar. Sebelum saya mengikuti perkuliahan Pemrograman Lanjut, terkadang saya masih menuliskan komentar terhadap alur program yang sebenarnya sudah jelas dari penamaan variabel serta alurnya, atau menuliskan kode yang terlalu panjang yang seharusnya bisa di-refactor menjadi beberapa variabel dengan penamaan variabel yang jelas. Kebiasaan tersebut sudah saya coba tinggalkan dan di sini saya menerapkan aturan penulisan kode yang sesuai dengan prinsip clean code. Saya tidak menuliskan komentar sama sekali di kode saya karena saya merasa penamaan variabel serta alur program sudah jelas sehingga tidak memerlukan komentar.
Ketiga, atribut dalam class saya buat visibilitasnya private agar class lain tidak bergantung dengan atribut tersebut.
Untuk peningkatan ke depan, saya dapat memulai untuk tidak lagi melakukan return null dalam sebuah function.

Reflection 2
1. Setelah membuat unit test, saya merasa kode saya lebih terjamin kebenarannya dan bekerja sesuai dengan keinginan saya. Menurut saya, sebanyak apapun unit test yang dibuat tidak cukup untuk memverifikasi program yang kita buat. Dalam aplikasi skala besar, testing tidak akan pernah berhenti. Ketika user menggunakan aplikasi kita, maka user tersebut sedang melakukan tes terhadap aplikasi kita.
2. Keputusan untuk membuat class baru dengan prosedur yang sama dapat dinilai kurang tepat. Hal tersebut tidak sesuai prinsip DRY dalam pemrograman yang merupakan akronim dari Don't Repeat Yourself yang berarti tidak boleh melakukan prosedur yang sama secara berulang. Test suite dapat ditingkatkan dengan membuat sebuah fungsi setup yang terpisah dengan fungsi tesnya. Dengan demikian, dapat terpenuhi aturan yang menyatakan bahwa satu fungsi menjalankan tepat satu hal.
