SELECT Sailors.C, Sailors.B, SUM(Reserves.G * Boats.D * Sailors.C) FROM Sailors, Reserves, Boats WHERE Sailors.A = Reserves.G AND Reserves.H = Boats.D GROUP BY Sailors.B, Sailors.C ORDER BY Sailors.C