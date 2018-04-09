SET search_path = "restaurant-rater";

CREATE TABLE Rater
(
	UserID INTEGER PRIMARY KEY,
	email VARCHAR(50),
	name VARCHAR(50) UNIQUE,
	join_date DATE,
	type VARCHAR(20),
	reputation INTEGER DEFAULT 1,
	password VARCHAR,
	CHECK (reputation < 6 AND reputation > 0)

);

CREATE TABLE Restaurant
(
 	RestaurantID INTEGER PRIMARY KEY,
	Name VARCHAR,
	Type VARCHAR,
	URL VARCHAR
);

CREATE TABLE Rating
(
	UserID INTEGER,
	Date DATE PRIMARY KEY,
	Price INTEGER,
	Food INTEGER,
	Mood INTEGER,
	Staff INTEGER,
	Comments VARCHAR,
	RestaurantID INTEGER,
	CHECK (Price < 6 AND  Price > 0),
	CHECK (Food < 6 AND  Food > 0),
	CHECK (Mood < 6 AND  Mood > 0),
	CHECK (Staff < 6 AND Staff > 0),
	FOREIGN KEY(UserID) REFERENCES Rater,
	FOREIGN KEY(RestaurantId) REFERENCES Restaurant
);


CREATE TABLE Location
(
	LocationID INTEGER PRIMARY KEY,
	first_open_date DATE,
	manager_name VARCHAR(20),
	phone_number VARCHAR(20),
	street_address VARCHAR(20),
	hour_open decimal(3,1),
	hour_close decimal(3,1),
	RestaurantID INTEGER
	CHECK( hour_open <= 24.0 AND hour_open >= 0.0),
	CHECK( hour_close <= 24.0 AND hour_close >= 0.0),
	FOREIGN KEY(RestaurantID) REFERENCES Restaurant
);

CREATE TABLE MenuItem
(
	ItemID INTEGER PRIMARY KEY,
	name VARCHAR,
	type VARCHAR(20),
	category VARCHAR(20),
	description VARCHAR,
	price decimal(4,2),
	RestaurantID INTEGER,
	FOREIGN KEY (RestaurantID) REFERENCES Restaurant
);

CREATE TABLE RatingItem
(
	UserID INTEGER,
	ItemID INTEGER,
	Date DATE,
	rating INTEGER,
	comment VARCHAR,
	CHECK (rating < 6 AND rating > 0),
	FOREIGN KEY (UserID) REFERENCES Rater,
	FOREIGN KEY (ItemID) REFERENCES MenuItem,
	FOREIGN KEY (Date) REFERENCES Rating

);


INSERT INTO Restaurant VALUES
  (0,'McDonald''s', 'American', 'mcdonalds.com/ca/en-ca.html'),
	(1,'Pizza Pizza', 'American', 'pizzapizza.ca'),
	(2,'Ng''s Cuisine', 'Chinese', 'ngscuisine.com'),
	(3,'Red Lobster', 'American', 'redlobster.ca'),
	(4, '168 Sushi Japanese Buffet', 'Japanese', '168sushibuffet.com'),
	(5, 'Cozmos Souvlaki', 'Greek', 'cozmossouvlaki.com'),
	(6,'Popeyes', 'American', 'popeyeschicken.ca'),
	(7,'3 Brothers Shawarma', 'Middle Eastern', 'www.3brothersshawarma.com'),
	(8,'The Fry', 'Korean', 'thefry.ca'),
	(9,'Mandarin', 'Chinese', 'mandarinrestaurant.com'),
	(10,'Harvey''s', 'American', 'harveys.ca'),
	(11,'Chako', 'Korean', 'chakobbq.com');

INSERT INTO MenuItem VALUES
	(0, 'Montreal Steak Spice BBQ Angus', 'food', 'main', '100% Angus beef with BBQ sauce, crispy onions, and natural Mozzarella cheese.', 9.99,0),
	(1, 'Big Mac', 'food', 'main', '100% Canadian beef, processed cheddar cheese, with famous Big Mac sauce.', 6.99, 0),
	(2, 'Oreo McFlurry', 'food', 'dessert', 'Creamy vanilla soft served mixed with Oreo', 2.39, 0),
	(3, '8 Jalapeno Poppers', 'food', 'starter', 'Stuffed jalapeno peppers with cream cheese then deep-fried.', 5.99, 1),
	(4, 'Chocolate Milk', 'beverage', 'main', 'Classic chocolate milk from the cow.', 2.09, 1),
	(5, 'Fresco - Chicken Bruschetta', 'food', 'main', '10" whole grain, thin crust with grilled chicken, roasted garlic, bruschetta, parmesan cheese and mozzarella cheese.', 5.00, 1),
	(6, '20 Chicken Wings', 'food', 'main', 'Classic or crispy breaded wings.', 18.99, 1),
	(7, 'Dry Scallop Seafood Soup', 'food', 'starter', 'With delicious fresh scallops.', 15.95, 2),
	(8, 'BBQ Pork Fried Rice', 'food', 'main', 'Sweet BBQ Pork with tender fried rice.', 8.95, 2),
	(9, 'Spicy Crispy Beef', 'food', 'main', 'Nice and spicy.', 12.55, 2),
	(10, 'Shirmp Linguine Alfredo', 'food', 'main', 'With our creamy Alfredo sauce.', 19.99, 3),
	(11, 'Key Lime Pie', 'food', 'dessert', 'A slice of our cool, tangy, creamy classic with a graham cracker crust.', 7.99, 3),
	(12, 'Mojito', 'beverage', 'main', 'We take Bacardi Superior rum, muddle it with fresh-squeezed lime, mint, pure cane sugar and top with club soda.', 4.99, 3),
	(13, 'Edamame', 'food', 'starter', 'Steamed Soy Bean with Lightly Salt.', 3.95, 4),
	(14, 'Banana Tempura (4pcs)', 'food', 'starter', 'Deep Fried Banana with sweet chocolate sauce.', 3.95, 4),
	(15, 'California', 'food', 'main', 'Crap meat, cucumber.', 4.95, 4),
	(16, 'Beef Souvlaki', 'food', 'main', 'Beef with Tzatzikiand soft peta bread.', 8.30, 5),
	(17, 'Chicken Souvlaki', 'food', 'main', 'Chicken with Tzatziki and soft peta bread.', 8.30, 5),
	(18, 'Poutine', 'food', 'main', 'Fries with fresh beef gravy and cheese curds.', 6.99, 5),
	(19, 'Greek Salad', 'food','main', 'With fresh feta cheese and olives.', 4.99, 5),
	(20, 'Bonafide Chicken', 'food', 'main', 'Our freshly prepared chicken, marinated in Popeyes spicy chicken marinade.', 6.99, 6),
	(21, 'Mashed Potatoes', 'food', 'starter', 'Smooth, creamy mashed potatoes covered with our flavourful cajun gravy.', 2.99, 6),
	(22, 'Soda', 'beverage', 'main', 'Cold beverage of your choice.', 1.99, 6),
	(23, 'Popcorn Shrimp', 'food', 'main', 'Tender crispy shrimp seasoned in Louisiana herbs.', 7.99, 6),
	(24, 'Onion Rings', 'food', 'main', 'Crispy battered onion rings', 7.99, 6),
	(25, 'Beef Poutine', 'food', 'main', 'Poutine served with beef.', 11.99, 7),
	(26, 'Shawarma', 'food', 'main', 'A wrap filled with vegetable and meat of your choosing.', 7.99, 7),
	(27, 'Soda', 'beverage', 'main', 'Cold beverage of your choice!', 1.99, 7),
	(28, 'BBQ Chicken', 'food', 'main', 'Half chicken marinated in BBQ sauce.', 12.99, 8),
	(29, 'Caesar salad', 'food', 'starter', 'A healthy caesar salad served with salad dressing.', 4.99, 8),
	(30, 'Milkshake', 'beverage', 'main', 'Cold milkshake of your choice!', 3.99, 8),
	(31, 'Sushi', 'food', 'main', 'A tray of any type of sushi of your choosing, freshly made.', 12.99, 9),
	(32, 'Ice Cream', 'food', 'dessert', 'A bowl of any flavour of ice cream.', 2.99, 9),
	(33, 'Beer', 'beverage', 'main', 'Cool brew of beer.', 3.99, 9),
	(34, 'Grilled Veggie Burger', 'food', 'main', 'Harvey''s signature Veggie Burger.', 8.99, 10),
	(35, 'Grilled Hot Dog', 'food', 'main', 'Our signature hot dog is flame-grilled to perfection and served on a fresh, lightly toasted bun.', 4.99, 10),
	(36, 'Slushie', 'beverage', 'main', 'Custom slushie with secret flavour.', 1.99, 10),
	(37, 'Beef', 'food', 'main', 'A tray of raw beef served to be grilled.', 12.99, 11),
	(38, 'Ice Cream', 'food', 'dessert','Mango or Pistachio flavour served fresh!', 2.99, 11),
	(39, 'Beer', 'beverage', 'main', 'Cool brew of beer.', 3.99, 11);

INSERT INTO Rater VALUES
	(0, 'alantran@hotmail.com', 'AlanTran', '2018-04-04' , 'food critic', 5, 'pass0'),
	(1, 'shicritic@gmail.com' ,'ShiCritic', '2015-07-30', 'blog', 4, 'pass1'),
	(2, 'makboolean@gmail.com', 'Makboolean', '2017-12-15', 'online', 4, 'pass2'),
	(3, 'supersizeme@gmail.com', 'SuperSizeMe', '2016-03-24', 'blog', 3, 'pass3'),
	(4, 'kbdproductions@gmail.com', 'KBDproductions', '1998-08-11', 'online', 5, 'pass4'),
	(5, 'superofficial@gmail.com', 'DaymnDrops', '2008-06-15', 'online', 2, 'pass5'),
	(6, 'pete@gmail.com', 'FuriousPete', '2014-02-20', 'food critic',1, 'pass6'),
	(7, 'peterlam@gmail.com', 'PokeFire', '2017-07-18', 'food critic', 5, 'pass7'),
	(8, 'saeed@gmail.com', 'SaeedSlayer', '2016-01-17', 'blog',4, 'pass8'),
	(9, 'haider@gmail.com', 'HaiderGod', '2016-01-06', 'online',5, 'pass9'),
	(10, 'amir@gmail.com', 'FattyAmir', '2015-02-13', 'food critic',2,'pass10'),
	(11, 'sam@gmail.com', 'SuperSam', '2014-01-02', 'food critic',3,'pass11'),
	(12, 'ali@gmail.com', 'LoudAli', '2013-03-04', 'online',3, 'pass12'),
	(13, 'bob@gmail.com', 'KingBob', '2014-01-18', 'online',3, 'pass13'),
	(14, 'kate@gmail.com', 'KateKills', '2015-03-02', 'blog',1, 'pass14'),
	(15, 'john@gmail.com', 'John', '2009-09-07', 'food critic',5, 'pass15'),
	(16, 'rob@gmail.com', 'Rob', '2016-04-05', 'online',3, 'pass16');

INSERT INTO Rating VALUES

	(1, '2018-07-27', 5, 4, 4, 5, 'Stitsville has the best employees!', 0),
	(2, '2018-06-14', 3, 4, 4, 4, 'Great fries and staff.', 0),
	(3, '2018-05-09', 5, 3, 4, 3, 'Price is right!', 0),
	(4, '2018-08-25', 1, 5, 5, 5, 'Amazing food and staff but too overpriced.', 0),
	(7, '2018-09-15', 4, 4, 4, 4, 'All around great.', 0),

	(2, '2018-10-08', 3, 3, 3, 3, 'Decent.', 1),
	(3, '2018-03-18', 2, 3, 3, 2, 'Food is okay.', 1),
	(5, '2018-01-07', 5, 3, 5, 5, 'Love everything except the food', 1),
	(6, '2018-04-17', 2, 2, 3, 3, 'Too expensive.', 1),
	(7, '2018-08-06', 3, 3, 3, 3, 'Everything could and should be better.', 1),

	(0, '2018-12-24', 4, 5, 5, 1, 'Staff should be improved, large wait times, and they should make sauces free.', 2),
	(3, '2018-02-03', 2, 2, 2, 2, 'Expected more.', 2),
	(4, '2018-02-18', 2, 3, 3, 2, 'Food is okay.', 2),
	(5, '2018-06-22', 4, 3, 3, 4, 'Price and staff is what makes this place great!', 2),
	(6, '2018-04-02', 5, 5, 5, 5, 'Irresistible', 2),

	(0, '2018-11-30', 2, 4, 4, 5, 'Great for families!',3),
	(1, '2018-07-05', 1, 2, 3, 4, 'Only good thing is their staff.', 3),
	(3, '2018-07-01', 4, 4, 4, 4, 'Wow amazing.', 3),
	(5, '2018-05-15', 3, 4, 4, 5, 'Great, went for my birthday.', 3),
	(6, '2018-09-03', 4, 4, 4, 4, 'So good.', 3),

	(0, '2018-12-26', 5, 4, 4, 5, 'One of the greatest', 4),
	(2, '2018-01-26', 5, 5, 5, 5, 'My ultimate favorite restaurant!', 4),
	(3, '2018-04-14', 3, 5, 3, 4, 'Yummy food!', 4),
	(5, '2018-02-14', 3, 4, 3, 4, 'Give it a try!', 4),
	(7, '2018-06-13', 4, 4, 5, 4, 'Wow! Im shocked how amazing it is!', 4),

	(1, '2018-07-11', 1, 1, 1, 1, 'Way too overpriced.', 5),
	(3, '2018-08-24', 3, 3, 3, 3, 'Okay overall.', 5),
	(4, '2018-09-12', 5, 4, 3, 2, 'Price is great, but staff do not pay attention.', 5),
	(6, '2018-12-13', 4, 4, 3, 4, 'The enviroment can be better.', 5),
	(7, '2018-07-17', 3, 3, 3, 3, 'Pretty decent.', 5),

	(11, '2018-07-18', 4, 5, 3, 4, 'The food was amazing, staff was quick and friendly and the mood was alright.', 6),
	(8, '2018-04-30', 5, 4, 4, 4, 'The food was great for the price.', 6),
	(14, '2018-04-5', 5, 3, 3, 3, 'Food was okay for the price.', 6),
	(7, '2018-04-13', 4, 3, 4, 3, 'Not bad food, price was cheap.', 6),
	(9, '2018-06-20', 4, 4, 3, 4, 'The food was great, and staff was friendly and nice', 6),

	(10, '2018-05-06', 2, 4, 5, 4, 'I liked the food, especially because it was cheap, decent staff too!', 7),
	(11, '2018-06-19', 1, 4, 4, 3, 'The food was great but it is OVERPRICED and staff is okay.', 7),
	(7, '2018-06-24', 1, 4, 4, 3, 'Overpriced, but good', 7),
	(12, '2018-08-05', 2, 4, 4, 4, 'The food was kind of overpriced, but since the staff was good it makes up for it', 7),
	(8, '2018-11-21', 2, 5, 4, 3, 'LOVED the good but overpriced.', 7),

	(9, '2018-07-14', 3, 5, 3, 4, 'The food was amazing, staff was quick and friendly and the mood was alright.', 8),
	(8, '2018-04-03', 4, 3, 4, 3, 'The waiting time was pretty short and the food was decent given it was quite cheap.', 8),
	(10, '2018-04-09', 4, 3, 4, 3, 'Cheap food, short wait, would reccommend.', 8),
	(11, '2018-05-05', 4, 3, 4, 3, 'The food was cheap!.', 8),
	(12, '2018-06-05', 5, 3, 4, 3, 'Cheap food, would reccommend to anyone.', 8),

	(12, '2018-08-12', 5, 2, 3, 4, 'The staff was great, however, the food was overpriced and the quality wasn''t that good.', 9),
	(7, '2018-12-07', 4, 2, 3, 4, 'The food was cheap, I would tell my friends about it, pretty good!', 9),
	(13, '2018-02-08', 3, 3, 4, 2, 'The staff wasn''t very oragnized, but the food was served nicely and tasted great', 9),
	(8, '2018-03-22', 4, 2, 3, 4, 'The food wasn''t that good.', 9),
	(14, '2018-09-13', 3, 4, 3, 5, 'Definitely one of the cheaper places I liked it!', 9),

	(9, '2018-06-01', 2, 5, 4, 3, 'The food was expensive but it was prepared delicately and tasted amazing.', 10),
	(10, '2018-06-27', 2, 3, 4, 4, 'Best food, but it was expensive.', 10),
	(14, '2018-06-03', 3, 2, 4, 3, 'The food was okay, but I''ve tasted better for the same price.', 10),
	(8, '2018-09-04', 3, 4, 4, 3, 'I liked me some good old murican'' food!', 10),
	(7, '2018-05-27', 2, 3, 4, 4, 'Great burgers, loved em!', 10),

	(13, '2018-04-12', 4, 3, 2, 3, 'The staff was slow and the food wasn''t very fresh.', 11),
	(12, '2018-03-15', 3, 4, 4, 5, 'Great food and staff, but slightly expensive, would reccommend to anyone craving korean bbq.', 11),
	(10, '2018-10-15', 3, 4, 4, 5, 'I loved the food. ', 11),
	(11, '2018-08-14', 4, 2, 3, 4, 'I didn''t really like food very much, quality was not that good.', 11),
	(7, '2018-04-06', 4, 3, 2, 3, 'Food wasn''t that fresh, but not bad either.', 11),
	
	
	--JOHN
	(15, '2015-11-25', 3, 3, 3, 3, 'I have seen better forsure.', 7),
	(15, '2015-08-25', 2, 3, 2, 3, 'Horrible.', 4),
	(15, '2017-04-18', 3, 3, 3, 3, 'Better than the last time I came.', 4),
	--mcds
	(15, '2011-06-28', 2, 2, 2, 2, 'Gross.', 0),
	(15, '2013-04-13', 4, 4, 1, 1, 'Horrible staff.', 0),
	
	--ROB
	(16, '2015-08-30',4, 4, 4,4, 'Super yummy.', 0),
	(16, '2017-11-28',5, 5, 5,5, 'Absolute favorite now.', 0);
	
INSERT INTO RatingItem VALUES
	-- 0
	(1, 2, '2018-07-27', 5, 'Mctasty!'),
	(2, 1, '2018-06-14', 4, 'Classic Big Mac yum.'),
	(3, 0, '2018-05-09', 3,'Montreal Steak is worth the money but taste is okay.'),

	-- 1
	(2, 6, '2018-10-08', 3, 'Wings are okay.'),
	(3, 3, '2018-03-18', 3, 'Too spicy.'),
	(5, 5, '2018-01-07', 3, 'Chicken was a little dry.'),

	-- 2
	(4, 7,'2018-02-18', 3, 'Portion size is small for the scallop.'),
	(5, 7,'2018-06-22', 3, 'Scallop was a little dry.'),
	(6, 9,'2018-04-02', 5, 'Very tender pork and good sauce'),

	-- 3
	(3, 12,'2018-07-01', 4, 'So fresh.'),
	(5, 10,'2018-05-15', 4, 'Tender noodles yum.'),
	(6, 11,'2018-09-03', 4, 'Nice and acidic.'),

	-- 4
	(0, 13,'2018-12-26', 4, 'Great as a starter.'),
	(5, 14,'2018-02-14', 4, 'Crispy and sweet!'),
	(7, 15,'2018-06-13', 4, 'Reminds me of LA.'),

	-- 5
	(1, 17,'2018-07-11', 1, 'Too much money and was very dry.'),
	(4, 18,'2018-09-12', 4, 'Gravy is delicious!'),
	(7, 18,'2018-07-17', 3, 'Not enough cheese but decent.'),

	-- 6
	(11, 20, '2018-07-18', 5, 'It was AMAZING!'),
	(8, 21, '2018-04-30', 4, 'The food was great'),
	(14, 22, '2018-04-05', 3,'Food was okay for the price.'),

	-- 7
	(10, 25, '2018-05-6', 4, 'I liked the food.'),
	(11, 26, '2018-06-19',4, 'The food was great.'),
	(7, 27, '2018-06-24', 4, 'Overpriced, but good'),

	-- 8
	(9, 28, '2018-07-14', 5, 'The food was amazing!'),
	(8, 29, '2018-04-03', 3, 'I thought it was decent.'),
	(10, 30, '2018-04-09', 3, 'Not bad at all for the price.'),

	-- 9
	(12, 31, '2018-08-12', 2, 'Qualit wasn''t that great'),
	(7, 32, '2018-12-07', 2,'Meh it was cheap I guess it''s ok'),
	(13, 33, '2018-02-08', 3, 'The food was served nicely and tasted great'),

	-- 10
	(9, 34, '2018-06-01', 5, 'It was prepared delicately and tasted amazing.'),
	(10, 35, '2018-06-27', 3, 'Best food I SWEAR'),
	(14, 36, '2018-06-03', 2, 'The food was okay'),

	-- 11
	(13, 37, '2018-04-12', 3,'The food wasn''t very fresh.'),
	(12, 38, '2018-03-15', 4,'Great food and staff I WAS CRAVING good dessert.'),
	(10, 39, '2018-10-15', 4, 'I loved the food.'),

	--John
	(15, 26, '2015-11-25', 3, 'I loved the food.'),
	(15, 14, '2015-08-25', 3, 'Crispy but very oily.'),
	(15, 15, '2017-04-18', 3, 'Not enough crab but still good.'),
	
	
	(15, 2, '2011-06-28', 2, 'Not cold at all.'),
	(15, 1, '2013-04-13', 4, 'Favorite on the menu.'),
	
	
	--ROB
	
	(16, 2, '2015-08-25', 4, 'Oreo Mcfurries wow.'),
	(16, 1, '2017-04-18', 5, 'I eat BigMacs everyday now!');
	
INSERT INTO LOCATION VALUES
	(0, '2008-10-03', 'Jesse Wellens', '123-245-6689', '121 Baseline Rd.', 7,22,0),
	(1, '2011-11-20', 'Peter Parker', '321-495-8888', '20 Barhaven Centre', 8,21,1),
	(2, '2013-07-09', 'Steve Rodgers', '666-123-8888', '11 Laurier St.', 6,20,2),
	(3, '2014-03-22', 'Jimmy Greek', '666-422-8888', '88 Draper', 10,23.9,3),
	(4, '2009-08-18', 'Candice Lalande', '666-126-8888', '919 Kanata', 0,23.9,4),
	(5, '2015-05-14', 'Zac Dell', '666-486-8888', '7 Terry Fox', 7,21,5),
	(6, '2016-04-15', 'Steve Jobs', '666-944-8888', '34 Kawilu', 8,22,6),
	(7, '2010-01-11', 'Bob The Great', '666-645-8888', '1045 Albert St.', 9,19,7),
	(8, '2011-04-15', 'Ash Catchem', '666-960-8888', 'Bayshore Mall', 08,20,8),
	(9, '2012-10-30', 'Rebecca Castrence', '666-421-8888', 'Rideau Mall', 7,20,9),
	(10, '2015-09-21', 'Sophie Hassen', '666-325-8888', 'University of Ottawa', 3,12,10),
	(11, '2014-11-12', 'Peter Banghoo', '666-657-8888', 'Carleton', 05,12,11),
	(12, '2009-01-01', 'Alan Tranny', '613-123-1234', '100 Baseline Rd.', 10, 19, 0),
	(13, '2009-04-15', 'Haider Bhan', '613-271-0294', '121 Rideau Rd.', 9, 19, 1),
	(14, '2010-03-20', 'Amy Shumer', '613-894-1928', '13 Markham Rd.', 10, 18, 2),
	(15, '2011-04-20', 'Ronald Dol', '613-123-4442', '40 Hue Rd.', 10, 18, 4),
	(16, '2008-03-25', 'Tinkle Bell', '613-512-5123', '18 Toodle Rd.', 10, 18, 5),
	(17, '2010-02-28', 'Benjamin Haider', '613-918-1092', '488 Reddit Rd.', 10, 18, 6),
	(18, '2007-04-13', 'Adolf Zao', '613-156-8272', '15 Westmount Rd.', 10, 18, 7),
	(19, '2008-01-18', 'Stalin Ship', '613-129-4921', '32 Burger Rd.', 10, 18, 8),
	(20, '2012-04-15', 'Jefferson Sin', '613-792-9123', '19 Harry Rd.', 8, 19, 9),
	(21, '2013-10-30', 'Fadi Malek', '613-523-5291', '600 Lingerine Rd.', 8, 17, 10),
	(22, '2004-05-16', 'Valentine Lo', '613-141-5966', '142 Stripper Rd.', 9, 19, 11);
	
--Restraurants and menus
--a
SELECT * FROM Restaurant AS R, Location AS L WHERE (R.RestaurantID = L.RestaurantID) AND (R.Name = User.nameR);

--b
SELECT M.name, M.price,  M.type, M.Category, M.description FROM MenuItem AS M, Restaurant AS R WHERE (R.RestaurantID = M.RestaurantID) ORDER BY M.category ASC; -- R.Name = User.nameR

--c
SELECT L.manager_name, L.first_open_date FROM Restaurant AS R, Location AS L WHERE R.RestaurantID = L.RestaurantID; --R.Categy = User.cat

--d
SELECT DISTINCT M.name, L.manager_name, L.hour_open, R.URL
FROM Location AS L, Restaurant AS R, MenuItem AS M
WHERE (L.RestaurantID = R.RestaurantID) AND (M.RestaurantID = R.RestaurantID)  AND M.Price IN(
	SELECT DISTINCT MAX(M2.price)
	FROM MenuItem as M2, Restaurant as R2
	WHERE (M2.RestaurantID = R2.RestaurantID) AND (R2.name = 'The Fry')) AND (R.name = 'The Fry');
	
--HOURS OPEN CHANGE DECIMAL, PRICE!!!
--e

SELECT R.Type, M.category, AVG(M.price) AS avgPriceCat 
FROM MenuItem AS M, Restaurant as R 
WHERE M.RestaurantID = R.RestaurantID
GROUP BY M.Category, R.Type ORDER BY R.type, M.category;

SELECT R.Type, M.category, AVG(M.price) AS avgPriceCat 
FROM MenuItem AS M, Restaurant as R 
WHERE M.RestaurantID IN
	(SELECT R2.RestaurantID FROM Restaurant As R2 WHERE R.type = R2.type) AND M.RestaurantID = R.RestaurantID
GROUP BY M.Category, R.Type ORDER BY R.type, M.Category;

-- Ratings of Restaurants

--f
SELECT R.name ,Rater.name, Rating.price, Rating.food, Rating.mood, Rating.staff
FROM Restaurant AS R, Rater, Rating 
WHERE (Rater.userid = Rating.userid and Rating.restaurantid = R.restaurantid)
GROUP BY R.name ,Rater.userId, Rating.price, Rating.food, Rating.mood, Rating.staff ORDER BY R.name, Rater.name;

--g
SELECT DISTINCT R.name, L.phone_number, R.type 
FROM Restaurant AS R, Location AS L, Rating 
WHERE R.restaurantid = L.restaurantid AND
	NOT EXISTS (SELECT Ratings.date 
				FROM Rating AS Ratings 
				WHERE date_part('year', rating.date) =2015 AND date_part('month', rating.date) = 01);
--h

SELECT DISTINCT R.name, L.first_open_date 
FROM Restaurant as R, Location as L, Rating 
WHERE  R.restaurantid = L.restaurantid AND Rating.restaurantid = R.restaurantid AND (rating.staff <
	--(SELECT MAX(Xratings.price) FROM Rater AS X ,Rating as Xratings WHERE Xratings.userid = X.userid AND X.userid = 14 )
	(SELECT MAX(Xratings.food) FROM Rater AS X ,Rating as Xratings WHERE Xratings.userid = X.userid AND X.userid = 14 )
	OR rating.staff < (SELECT MAX(Xratings.staff) FROM Rater AS X ,Rating as Xratings WHERE Xratings.userid = X.userid AND X.userid = 14 )
	OR rating.staff <	(SELECT MAX(Xratings.mood) FROM Rater AS X ,Rating as Xratings WHERE Xratings.userid = X.userid AND X.userid = 14 ))


--i
SELECT R.name, Rater.name --Type
FROM Restaurant AS R, Rater, Rating
WHERE R.Type = 'American' AND Rater.userid = Rating.userid AND Rating.restaurantid = R.restaurantid AND Rating.food IN
	(SELECT DISTINCT MAX(Rating.food) FROM Rating, Restaurant as R2 WHERE R2.type = 'American'
	);
	
	
--j
--GIVEN TYPE Y
SELECT(case WHEN exists 
	   	(SELECT COUNT(Rate) 
		FROM Restaurant as R, Rating as Rate 
		WHERE R.type = 'American' 
		AND R.restaurantid = rate.restaurantid HAVING COUNT(*)> ANY(
			SELECT COUNT(Rating)
			FROM Restaurant AS R, Rating 
			WHERE R.restaurantid = Rating.restaurantid 
			GROUP BY R.type)
		) 
then 1 
else 0 end);

--k
SELECT RT.Name, RT.join_date, RT.reputation, R.Name, RG.Date
FROM Rater AS RT, Restaurant AS R, Rating AS RG
WHERE RT.UserId IN
(SELECT RT1.UserId
 FROM Rater AS RT1 GROUP BY RT1.UserId HAVING
		(SELECT AVG(RG1.Mood + RG1.Food)
		FROM Rating AS RG1
		WHERE RG1.UserId = RT1.UserId) >= ALL(
		SELECT AVG(RG2.mood + RG2.food)
		FROM Rating AS RG2, Rater AS RT2
		WHERE RG2.UserId = RT2.UserId GROUP BY RT2.UserId))
		AND RG.UserId = RT.UserId AND RG.RestaurantID = R.RestaurantID;
		
-- L

SELECT RT.name, RT.join_date, RT.reputation, R.name, RG.Date 
FROM Rater AS RT, Restaurant AS R, Rating AS RG 
WHERE RT.UserId IN (SELECT RG1.UserId FROM Rater AS RG1 
	WHERE
		(SELECT AVG(mood) FROM Rating AS RT1 WHERE RT1.UserId = RG1.UserId)
			>= ALL(SELECT AVG(mood) FROM Rating AS RT1 GROUP BY RT1.UserId)
		OR (SELECT AVG(food) FROM Rating AS RT1 WHERE RT1.UserId = RG1.UserId)
			>= ALL(SELECT AVG(food) FROM Rating AS RT1 GROUP BY RT1.UserId))
		AND RG.UserId = RT.UserID AND RG.RestaurantID = R.RestaurantID;
		
--m

SELECT DISTINCT RT.name, RT.reputation,RG.comments, MenuItem.name, MenuItem.price 
FROM Rating AS RG, Rater AS RT, RatingItem, MenuItem
WHERE 
	RT.userId IN (SELECT RT1.userId 
				FROM Rater AS RT1 
				WHERE
		(SELECT COUNT(*) FROM Rating AS RG1 WHERE RG1.userId = RT1.userId AND
			RatingItem.userid = RT.userid 
			AND RatingItem.itemid = menuitem.itemid
			AND RG1.restaurantid = menuitem.restaurantid
			AND RG1.restaurantId IN (SELECT R.restaurantId 
								FROM Restaurant AS R 
								WHERE R.name ='McDonald''s')) >=  All(SELECT COUNT(*) FROM Rating AS RG2 WHERE 
			RG2.restaurantId IN (SELECT R.restaurantId FROM Restaurant AS R WHERE
				R.name ='McDonald''s') GROUP BY RG2.userId))
	AND RG.userId = RT.userId AND RG.restaurantId IN (SELECT R.restaurantId FROM Restaurant AS R WHERE
				R.name ='McDonald''s');
				
--Z = mcdonalds
SELECT DISTINCT Rater.name, Rater.reputation, Rating.comments, RatingItem.comment, MenuItem.name, MenuItem.price
FROM Rater, Rating, Restaurant, RatingItem, MenuItem
WHERE Rater.userid = Rating.userid 
	AND Restaurant.restaurantID = Rating.restaurantID
	AND RatingItem.userid = Rater.userId
	AND MenuItem.itemid = RatingItem.itemid
	AND MenuItem.restaurantid = Restaurant.
	AND Restaurant.name = 'McDonald''s'; --GROUP BY Rater.name, Rater.reputation HAVING COUNT(*) > 2;



--n 100%
SELECT DISTINCT Rater.name, Rater.email
FROM Rater, Rating
WHERE Rater.userid = Rating.userid AND (Rating.price + Rating.food + Rating.mood + Rating.staff) < ANY(
SELECT (Rating.price + Rating.food + Rating.mood + Rating.staff) AS JohnRatings
FROM Rating, Rater 
WHERE Rating.userid = Rater.userid AND Rater.name = 'John');


