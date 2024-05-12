Create database BeeFit
go
use BeeFit
go

create table Role (
										 Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
										 Name NVARCHAR(50),
										 CreateDate DATETIME,
										 UpdateDate DATETIME,
										 CreateBy VARCHAR(30),
										 UpdateBy VARCHAR(30),
										 Status INT
)
Create table Employee(
										 Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
										 Code VARCHAR(30) UNIQUE,
										 Fullname NVARCHAR(100) ,
										 Username VARCHAR(30) UNIQUE,
										 Password VARCHAR(30),
										 Image VARCHAR(255),
										 Gender BIT,
										 Phone VARCHAR(15),
										 Email VARCHAR(50),
										 CreateDate DATETIME,
										 UpdateDate DATETIME,
										 CreateBy VARCHAR(30),
										 UpdateBy VARCHAR(30),
										 Status INT,
										 IdRole INT FOREIGN KEY REFERENCES Role(Id)
)
Create table Customer(
										 Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
										 Code VARCHAR(30) UNIQUE,
										 Fullname NVARCHAR(100),
										 Username VARCHAR(30) UNIQUE,
										 Password VARCHAR(30),
										 Image VARCHAR(255),
										 Gender BIT,
										 Phone VARCHAR(15),
										 Email VARCHAR(50),
										 CreateDate DATETIME,
										 UpdateDate DATETIME,
										 CreateBy VARCHAR(30),
										 UpdateBy VARCHAR(30),
										 Status INT,
)
Create table Product(
										 Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
										 Code VARCHAR(30),
										 Name NVARCHAR(100),
										 Description NVARCHAR(255),
										 CreateDate DATETIME,
										 UpdateDate DATETIME,
							 			 CreateBy VARCHAR(30),
							 			 UpdateBy VARCHAR(30),
										 Status INT

)
Create table Category(
										 Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
										 Name NVARCHAR(100),
										 Description NVARCHAR(255),
										 CreateDate DATETIME,
										 UpdateDate DATETIME,
										 CreateBy VARCHAR(30),
										 UpdateBy VARCHAR(30),
										 Status INT
)
Create table Brand(
										 Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
										 Name NVARCHAR(100),
										 Description NVARCHAR(255),
										 CreateDate DATETIME,
										 UpdateDate DATETIME,
										 CreateBy VARCHAR(30),
										 UpdateBy VARCHAR(30),
										 Status INT
)
Create table Design(
										 Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
										 Name NVARCHAR(100),
										 Description NVARCHAR(255),
										 CreateDate DATETIME,
										 UpdateDate DATETIME,
										 CreateBy VARCHAR(30),
										 UpdateBy VARCHAR(30),
										 Status INT
)
Create table SleeveType(
										 Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
										 Name NVARCHAR(100),
										 Description NVARCHAR(255),
										 CreateDate DATETIME,
										 UpdateDate DATETIME,
										 CreateBy VARCHAR(30),
										 UpdateBy VARCHAR(30),
										 Status INT
)
Create table CollarType(
										 Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
										 Name NVARCHAR(100),
										 Description NVARCHAR(255),
										 CreateDate DATETIME,
										 UpdateDate DATETIME,
										 CreateBy VARCHAR(30),
										 UpdateBy VARCHAR(30),
										 Status INT
)
Create table ProductImage(
										 Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
										 Url NVARCHAR(255),
										 MainImage BIT,
										 CreateDate DATETIME,
										 UpdateDate DATETIME,
										 CreateBy VARCHAR(30),
										 UpdateBy VARCHAR(30),
										 Status INT,
										 IdProduct INT FOREIGN KEY REFERENCES Product(Id)
)
Create table ProductDetail(
									     Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,                    
									     Price MONEY,
									     Description NVARCHAR(255),							 
									     CreateDate DATETIME,
									     UpdateDate DATETIME,
									     CreateBy VARCHAR(30),
									     UpdateBy VARCHAR(30),    
									     Status INT,
									     IdProduct INT FOREIGN KEY REFERENCES Product(Id),
									     IdBrand INT FOREIGN KEY REFERENCES Brand(Id),								
									     IdCategory INT FOREIGN KEY REFERENCES Category(Id),
										 IdSleeve INT FOREIGN KEY REFERENCES SleeveType(Id),
										 IdCollar INT FOREIGN KEY REFERENCES CollarType(Id),
									     IdDesign INT FOREIGN KEY REFERENCES Design(Id)
)
Create table Material(
										 Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
										 Name NVARCHAR(100),
										 Description NVARCHAR(255),
										 CreateDate DATETIME,
										 UpdateDate DATETIME,
										 CreateBy VARCHAR(30),
										 UpdateBy VARCHAR(30),
										 Status INT
)
Create table ProductDetail_Material(
										 Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
										 IdProductDetail INT FOREIGN KEY REFERENCES ProductDetail(Id),
										 IdMaterial INT FOREIGN KEY REFERENCES Material(Id)
)
Create table Size(
										 Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
										 Name NVARCHAR(100),
										 Description NVARCHAR(255),
										 CreateDate DATETIME,
										 UpdateDate DATETIME,
										 CreateBy VARCHAR(30),
										 UpdateBy VARCHAR(30),
										 Status INT
)
Create table Color(
										 Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
										 Name NVARCHAR(100),
										 Description NVARCHAR(255),
										 CreateDate DATETIME,
										 UpdateDate DATETIME,
										 CreateBy VARCHAR(30),
										 UpdateBy VARCHAR(30),
										 Status INT
)
Create table ProductDetail_Color_Size(
                                         Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
										 Quantity INT,
                                         IdProductDetail INT FOREIGN KEY REFERENCES ProductDetail(Id),
                                         IdColor INT FOREIGN KEY REFERENCES Color(Id),
                                         IdSize INT FOREIGN KEY REFERENCES Size(Id),                                 
)
Create table Voucher(
										 Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
										 Code VARCHAR(30),
										 Name NVARCHAR(100),
										 TypeVoucher BIT,
										 IsVoucher BIT,
										 Discount INT ,
										 Cash MONEY,
										 StartDate DATETIME,
										 EndDate DATETIME,			
										 CreateDate DATETIME,
										 UpdateDate DATETIME,
										 CreateBy VARCHAR(30),
										 UpdateBy VARCHAR(30),
										 Status INT
)
Create table Product_Voucher(
										 Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
										 IdVoucher INT FOREIGN KEY REFERENCES Voucher(Id),
										 IdProduct INT FOREIGN KEY REFERENCES Product(Id),
)
Create table Address(
										 Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
										 Fullname NVARCHAR(100),
										 Phone VARCHAR(15),
										 Address NVARCHAR(255),
									 	 CityName NVARCHAR(100),
										 DistrictName NVARCHAR(100),
										 WardName NVARCHAR(100),
										 CityId INT,
										 DistrictId INT ,
										 WardId INT,
										 CreateDate DATETIME,
										 UpdateDate DATETIME,
										 CreateBy VARCHAR(30),
										 UpdateBy VARCHAR(30),
										 Status INT,
										 IdCustomer INT FOREIGN KEY REFERENCES Customer(Id),
)
Create table Bill(
										 Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
										 Code VARCHAR(30),
										 PurchaseDate DATETIME,
										 EstimatedDate DATETIME,
										 PaymentDate DATETIME,
										 DelyveryDate DATETIME,
										 TotalPrice MONEY,
										 ShipPrice MONEY,
										 TotalPriceLast MONEY,
										 Note NVARCHAR(255),
										 PayType INT ,
										 PayStatus INT,
										 TypeStatus INT,
										 CodeGHN VARCHAR(30),
										 Status INT,
										 IdAddress INT FOREIGN KEY REFERENCES Address(Id),
										 IdCustomer INT FOREIGN KEY REFERENCES Customer(Id),
										 IdVoucher INT FOREIGN KEY REFERENCES Voucher(Id),
										 IdEmployee INT FOREIGN KEY REFERENCES Employee(Id)
)
Create table BillDetail(
										 Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
										 UnitPrice MONEY,
										 Quantity INT,
										 IdColor INT,
										 IdSize INT,
										 IdOrder INT FOREIGN KEY REFERENCES Bill(Id),
										 IdProductDetail INT FOREIGN KEY REFERENCES ProductDetail(Id)
)
Create table BillHistory(
										 Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
										 Note NVARCHAR(255),
										 CreateDate DATETIME,
										 UpdateDate DATETIME,
										 CreateBy VARCHAR(30),
										 UpdateBy VARCHAR(30),
										 Status INT,
										 IdOrder INT FOREIGN KEY REFERENCES Bill(Id)
)
Create table Cart(
									     Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
									     IdCustomer INT FOREIGN KEY REFERENCES Customer(Id)
)
Create table CartDetail(
								         Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
								         UnitPrice MONEY,
								         Quantity INT,
								         IdColor INT,
								         IdSize INT,
								         IdCart INT FOREIGN KEY REFERENCES Cart(Id),
								         IdProductDetail INT FOREIGN KEY REFERENCES ProductDetail(Id)
)


-- Thêm dữ liệu vào bảng "role"
INSERT INTO Role (Name, CreateDate, UpdateDate, CreateBy, UpdateBy, Status)
VALUES ('Admin',  GETDATE() , GETDATE() , 'Admin', 'Admin', 0);

-- Thêm dữ liệu vào bảng "employee"
INSERT INTO Employee (Code, Fullname, Username, Password, Image, Gender, Phone, Email, CreateDate, UpdateDate, CreateBy, UpdateBy, status, IdRole)
VALUES ('NV01', 'John Doe', 'sa', '123456', 'Image URL', 1, '0123456789', 'employee@example.com',  GETDATE() , GETDATE() , 'Admin', 'Admin', 0, 1);

