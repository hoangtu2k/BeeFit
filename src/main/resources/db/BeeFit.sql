Create database BeeFit
go
use BeeFit
go

-- Create Category
Create table Category(
										 Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
										 Name NVARCHAR(100),
										 CreateDate DATETIME,
										 UpdateDate DATETIME,
										 CreateBy VARCHAR(30),
										 UpdateBy VARCHAR(30),
										 Status INT
)
-- Create Brand
Create table Brand(
										 Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
										 Name NVARCHAR(100),
										 CreateDate DATETIME,
										 UpdateDate DATETIME,
										 CreateBy VARCHAR(30),
										 UpdateBy VARCHAR(30),
										 Status INT
)
-- Create Design
Create table Design(
										 Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
										 Name NVARCHAR(100),
										 CreateDate DATETIME,
										 UpdateDate DATETIME,
										 CreateBy VARCHAR(30),
										 UpdateBy VARCHAR(30),
										 Status INT
)
-- Create NeckType
Create table NeckType(
										 Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
										 Name NVARCHAR(100),
										 CreateDate DATETIME,
										 UpdateDate DATETIME,
										 CreateBy VARCHAR(30),
										 UpdateBy VARCHAR(30),
										 Status INT
)
-- Create HandType
Create table HandType(
										 Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
										 Name NVARCHAR(100),
										 CreateDate DATETIME,
										 UpdateDate DATETIME,
										 CreateBy VARCHAR(30),
										 UpdateBy VARCHAR(30),
										 Status INT
)
-- Create Product
Create table Product(
										 Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
										 Code VARCHAR(30),
										 Name NVARCHAR(100),
										 Weight FLOAT,
										 Price MONEY,
										 Discount INT ,
										 DiscountDate DATETIME,
									     Description NVARCHAR(MAX),
									     CreateDate DATETIME,
									     UpdateDate DATETIME,
									     CreateBy VARCHAR(30),
									     UpdateBy VARCHAR(30),    
									     Status INT,	
									     IdBrand INT FOREIGN KEY REFERENCES Brand(Id),								
									     IdCategory INT FOREIGN KEY REFERENCES Category(Id),
										 IdNeckType INT FOREIGN KEY REFERENCES NeckType(Id),
										 IdHandType INT FOREIGN KEY REFERENCES HandType(Id),
									     IdDesign INT FOREIGN KEY REFERENCES Design(Id),
)
-- Create ProductImage
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
-- Create Material
Create table Material(
										 Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
										 Name NVARCHAR(100),
										 CreateDate DATETIME,
										 UpdateDate DATETIME,
										 CreateBy VARCHAR(30),
										 UpdateBy VARCHAR(30),
										 Status INT
)
-- Create ProductDetail_Material
Create table ProductDetail_Material(
										 Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
										 IdProduct INT FOREIGN KEY REFERENCES Product(Id),
										 IdMaterial INT FOREIGN KEY REFERENCES Material(Id)
)
-- Create Size
Create table Size(
										 Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
										 Name NVARCHAR(100),
										 CreateDate DATETIME,
										 UpdateDate DATETIME,
										 CreateBy VARCHAR(30),
										 UpdateBy VARCHAR(30),
										 Status INT
)
-- Create Color
Create table Color(
										 Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
										 Name NVARCHAR(100),
										 CreateDate DATETIME,
										 UpdateDate DATETIME,
										 CreateBy VARCHAR(30),
										 UpdateBy VARCHAR(30),
										 Status INT
)
-- Create ProductDetail_Color_Size
Create table ProductDetail_Color_Size(
                                         Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,										 
                                         IdProduct INT FOREIGN KEY REFERENCES Product(Id),
                                         IdColor INT FOREIGN KEY REFERENCES Color(Id),
                                         IdSize INT FOREIGN KEY REFERENCES Size(Id),   
										 Quantity INT,
)

-----------------------------------------    product     --------------------------------------------

-- Create Role
create table Role (
										 Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
										 Name NVARCHAR(50),
										 CreateDate DATETIME,
										 UpdateDate DATETIME,
										 CreateBy VARCHAR(30),
										 UpdateBy VARCHAR(30),
										 Status INT
)
-- Create Employee
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
-- Create Customer
Create table Customer(
										 Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
										 Code VARCHAR(30),
										 Fullname NVARCHAR(100),
										 Username VARCHAR(30),
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
Create table Voucher(
										 Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
										 Code VARCHAR(30),
										 Name NVARCHAR(100),
                                         DiscountType BIT,
										 Discount INT,
										 Cash MONEY,
										 StartDate DATETIME,
										 EndDate DATETIME,
										 Quantity INT,
                                         CreateDate DATETIME,
                                         UpdateDate DATETIME,
                                         CreateBy VARCHAR(30),
                                         UpdateBy VARCHAR(30),
                                         Status INT,
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
										 Status INT,
										 CodeGHN VARCHAR(30),
										 IdCoupon INT,
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
                                         IdProduct INT FOREIGN KEY REFERENCES Product(Id)
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
								         IdProduct INT FOREIGN KEY REFERENCES Product(Id)
)
Create table Rating(
									     Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
									     Score INT,
									     Note nvarchar(255),
									     CreateDate DATETIME,
									     UpdateDate DATETIME,
									     CreateBy VARCHAR(30),
									     UpdateBy VARCHAR(30),
									     Status INT,
									     IdProduct INT FOREIGN KEY REFERENCES Product(Id),
									     IdCustomer INT FOREIGN KEY REFERENCES Customer(Id)

)
Create table RatingImage(
                                         Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
                                         Url VARCHAR(255),
                                         IdRating INT FOREIGN KEY REFERENCES Rating(Id)
)
-- Create Coupon
Create table Coupon(
									     Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
									     Code VARCHAR(30),
									     Name NVARCHAR(100),
									     IsType INT,
										 Discount INT,
										 Cash MONEY,
										 StartDate DATETIME,
										 EndDate DATETIME,	
									     CreateDate DATETIME,
										 UpdateDate DATETIME,
										 CreateBy VARCHAR(30),
										 UpdateBy VARCHAR(30),
									     Status INT,
										 IdCustomer INT FOREIGN KEY REFERENCES Customer(Id)
)
Create table Background(
									     Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
									     Type VARCHAR(30),
									     Url VARCHAR(255),
									     Content NVARCHAR(255),
									     CreateDate DATETIME,
									     UpdateDate DATETIME,
									     CreateBy VARCHAR(30),
									     UpdateBy VARCHAR(30),
									     Status INT
)


------------------------------------- Inser into product start ------------------------------------------
-- Thêm dữ liệu vào bảng "Category"
INSERT INTO Category(Name, CreateDate, UpdateDate, CreateBy, UpdateBy, Status)
VALUES (N'Áo thun tay ngắn',  GETDATE() , GETDATE() , 'Admin', 'Admin', 0),
	   (N'Áo thun tay dài',  GETDATE() , GETDATE() , 'Admin', 'Admin', 0);

-- Thêm dữ liệu vào bảng "Design"
INSERT INTO Design(Name, CreateDate, UpdateDate, CreateBy, UpdateBy, Status)
VALUES (N'Họa tiết kẻ sọc ngang trẻ trung',  GETDATE() , GETDATE() , 'Admin', 'Admin', 0),
	   (N'Thiết kế logo bóng chày in nổi bật ở ngực trái',  GETDATE() , GETDATE() , 'Admin', 'Admin', 0);

-- Thêm dữ liệu vào bảng "Brand"
INSERT INTO Brand(Name, CreateDate, UpdateDate, CreateBy, UpdateBy, Status)
VALUES ('MLB',  GETDATE() , GETDATE() , 'Admin', 'Admin', 0),
	   ('H&M',  GETDATE() , GETDATE() , 'Admin', 'Admin', 0);

-- Thêm dữ liệu vào bảng "NeckType"
INSERT INTO NeckType(Name, CreateDate, UpdateDate, CreateBy, UpdateBy, Status)
VALUES (N'Cổ tròn',  GETDATE() , GETDATE() , 'Admin', 'Admin', 0),
	   (N'Cổ chữ V',  GETDATE() , GETDATE() , 'Admin', 'Admin', 0);

-- Thêm dữ liệu vào bảng "HandType"
INSERT INTO HandType(Name, CreateDate, UpdateDate, CreateBy, UpdateBy, Status)
VALUES (N'Tay ngắn',  GETDATE() , GETDATE() , 'Admin', 'Admin', 0),
	   (N'Tay dài',  GETDATE() , GETDATE() , 'Admin', 'Admin', 0);

-- Thêm dữ liệu vào bảng "Material"
INSERT INTO Material(Name, CreateDate, UpdateDate, CreateBy, UpdateBy, Status)
VALUES ('Cotton',  GETDATE() , GETDATE() , 'Admin', 'Admin', 0),
	   ('TBC',  GETDATE() , GETDATE() , 'Admin', 'Admin', 0),
	   ('Polyester',  GETDATE() , GETDATE() , 'Admin', 'Admin', 0);

-- Thêm dữ liệu vào bảng "Color"
INSERT INTO Color(Name, CreateDate, UpdateDate, CreateBy, UpdateBy, Status)
VALUES (N'Den',  GETDATE() , GETDATE() , 'Admin', 'Admin', 0),
	   (N'Trắng',  GETDATE() , GETDATE() , 'Admin', 'Admin', 0),
	   (N'Đỏ',  GETDATE() , GETDATE() , 'Admin', 'Admin', 0),   
	   (N'Hồng',  GETDATE() , GETDATE() , 'Admin', 'Admin', 0),
	   (N'Vàng',  GETDATE() , GETDATE() , 'Admin', 'Admin', 0);

-- Thêm dữ liệu vào bảng "Size"
INSERT INTO Size(Name, CreateDate, UpdateDate, CreateBy, UpdateBy, Status)
VALUES ('S',  GETDATE() , GETDATE() , 'Admin', 'Admin', 0),
	   ('M',  GETDATE() , GETDATE() , 'Admin', 'Admin', 0),
	   ('L',  GETDATE() , GETDATE() , 'Admin', 'Admin', 0),
	   ('XL',  GETDATE() , GETDATE() , 'Admin', 'Admin', 0);


-------------------------------------- Inser into product end --------------------------------------------

-- Thêm dữ liệu vào bảng "role"
INSERT INTO Role (Name, CreateDate, UpdateDate, CreateBy, UpdateBy, Status)
VALUES ('Admin',  GETDATE() , GETDATE() , 'Admin', 'Admin', 0),
	   ('Staff',  GETDATE() , GETDATE() , 'Admin', 'Admin', 0);

-- Thêm dữ liệu vào bảng "employee"
INSERT INTO Employee (Code, Fullname, Username, Password, Image, Gender, Phone, Email, CreateDate, UpdateDate, CreateBy, UpdateBy, status, IdRole)
VALUES ('NV01', 'John Doe staff', 'staff', '123456', 'Image URL', 1, '0123456789', 'employee@example.com',  GETDATE() , GETDATE() , 'Admin', 'Admin', 0, 2),
	   ('NV02', 'John Doe admin', 'admin', '123456', 'Image URL', 1, '0123456789', 'employee@example.com',  GETDATE() , GETDATE() , 'Admin', 'Admin', 0, 1);

-- Thêm dữ liệu vào bảng "customer"
INSERT INTO Customer (Code, Fullname, Username, Password, Image, Gender, Phone, Email, CreateDate, UpdateDate, CreateBy, UpdateBy, status)
VALUES ('NV01', 'Customer', 'sa', '123456', 'Image URL', 1, '0123456789', 'employee@example.com',  GETDATE() , GETDATE() , 'Admin', 'Admin', 0);

-- Thêm dữ liệu vào bảng "cart"
INSERT INTO Cart (IdCustomer) 
VALUES (1);


