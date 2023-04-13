CREATE TABLE Actor (
                       id INT PRIMARY KEY,
                       name VARCHAR(255),
                       address VARCHAR(255),
                       social_network VARCHAR(255),
                       mobile_phone VARCHAR(20)
);

INSERT INTO Actor (id, name, address, social_network, mobile_phone)
VALUES
    (1, 'Tom Hanks', '123 Main St, Los Angeles, CA', 'twitter.com/tomhanks', '(555) 555-1212'),
    (2, 'Sandra Bullock', '456 Oak Ave, New York, NY', 'facebook.com/sandrabullock', '(555) 555-1213'),
    (3, 'Robert De Niro', '789 Elm St, Chicago, IL', 'instagram.com/robertdeniro', '(555) 555-1214'),
    (4, 'Meryl Streep', '321 Pine St, San Francisco, CA', 'twitter.com/merylstreep', '(555) 555-1215'),
    (5, 'Leonardo DiCaprio', '654 Maple Rd, Miami, FL', 'facebook.com/leonardodicaprio', '(555) 555-1216'),
    (6, 'Jennifer Lawrence', '987 Cedar Blvd, Seattle, WA', 'instagram.com/jenniferlawrence', '(555) 555-1217'),
    (7, 'Denzel Washington', '246 Cherry Ln, Houston, TX', 'twitter.com/denzelwashington', '(555) 555-1218'),
    (8, 'Angelina Jolie', '135 Walnut St, Philadelphia, PA', 'facebook.com/angelinajolie', '(555) 555-1219'),
    (9, 'Brad Pitt', '864 Rose Ave, Boston, MA', 'instagram.com/bradpitt', '(555) 555-1220'),
    (10, 'Julia Roberts', '753 Sunflower Ct, Dallas, TX', 'twitter.com/juliaroberts', '(555) 555-1221');