create database test_technical_query;

create table nasabah(
	kode varchar(5) not null primary key,
	nama varchar(15) not null
)

select * from nasabah;

insert into nasabah(kode, nama)
values
('CL001', 'Nana'),
('CL002', 'Dewa Buana'),
('CL003', 'Lula'),
('CL004', 'Livia Putri'),
('CL005', 'Roni Hermawan'),
('CL006', 'Pasha Bayu')

select kode as "Kode", nama as "Nama" 
from nasabah;

create table transaksi(
	id serial not null primary key,
	tanggal date not null,
	kode varchar(5) not null,
	produk varchar(2) not null,
	hargaSatuan decimal not null,
	kuantitas int not null,
	constraint fk_nasabah_transaksi foreign key(kode) references nasabah(kode)
)

select * from transaksi;

insert into transaksi(tanggal, kode, produk, hargaSatuan, kuantitas)
values 
('2024-01-01', 'CL001', 'AA', 2500, 300),
('2024-01-01', 'CL002', 'AA', 2400, 1000),
('2024-01-01', 'CL003', 'AA', 2500, 200),
('2024-01-01', 'CL004', 'AA', 2300, 500),
('2024-01-01', 'CL005', 'AA', 2400, 500),
('2024-01-01', 'CL006', 'AA', 2300, 700),
('2024-01-01', 'CL001', 'BB', 500, 200),
('2024-01-01', 'CL005', 'BB', 500, 200),
('2024-02-01', 'CL001', 'AA', 2500, 200),
('2024-02-01', 'CL002', 'AA', 2500, 3000),
('2024-02-01', 'CL003', 'AA', 2500, 100),
('2024-02-01', 'CL004', 'AA', 2500, 500),
('2024-02-01', 'CL005', 'AA', 2500, 400),
('2024-02-01', 'CL001', 'BB', 450, 100),
('2024-02-01', 'CL005', 'BB', 450, 100),
('2024-03-01', 'CL001', 'AA', 2400, 500),
('2024-03-01', 'CL002', 'AA', 2400, 500),
('2024-04-01', 'CL001', 'AA', 2000, 500),
('2024-04-01', 'CL003', 'AA', 2000, 500),
('2024-04-01', 'CL004', 'AA', 2000, 500)

select to_char(tanggal, 'FMDD/FMMM/YYYY') as "Tanggal", kode as "Kode", produk as "Produk", 
hargaSatuan as "HargaSatuan", kuantitas as "Kuantitas"  
from transaksi;

---------------------------------------
------ SOAL TEST 2 QUERY NOMOR 1 ------
---------------------------------------

select t.kode as "Kode", n.nama as "NamaNasabah", 
count(*) as "Frekuensi", sum (t.hargaSatuan * t.kuantitas) as "Total Transaksi"
from transaksi as t
join nasabah as n on n.kode = t.kode
group by t.kode, n.nama
order by "Total Transaksi" desc
limit 3;

---------------------------------------
------ SOAL TEST 2 QUERY NOMOR 2 ------
---------------------------------------

select produk as "Produk", min(hargaSatuan) as "Harga Satuan"
from transaksi
group by produk;