# Advanced Analytics with Spark published by O'Reilly written by Ryza et al., 2015.

Dataset: We have 141,000 unique users, 1.6 million unique artists and 24.2 million user plays.

Topics:

###Alternating Least Squares (ALS):

Since there is no explicit information about users and the artists they like we search for **implicit** feedback data. It's important to not that in this case the data is rather sparse because some users may have only listened to a single artists and it's unlikely that a user has listened to a significant number of the possible number of artists.

###Latent Factor Model:

These models try to explain the **observed interactions** between **users** and **products** (artists in this case) through a relatively small number of unobserved, underlying reasons. 

###Matrix Factorization Model:

User and product data are treated as a large matrix *A* where A[*i*][*j*] represents user *i*'s play data for artist *j*. By factoring matrix A into the product of matrices *X* and *Y* we gain some insight at **latent factors** behind the data. We discover some size *k* that the two matrixes *X* and *Y* must share to be multipled.

It's important to note two things:
* Factorization is feasible because *k* is assumed to be small
* *X* and *Y* end up being dense through this process.

The small valued *k* could be interpreted as taste or genre in this context.

Factoring *A* into *X* and *Y* is impossible if we don't know *X* or *Y* so we start off ALS with completely randomized data for one matrix and solve for the other. If *Y* is random we minimize the absolute difference |*A<sub>i</sub>Y(Y<sup>T</sup>Y)<sup>-1</sup>* - X|. (Instead of computing inverses it's common to use [QR decomposition](https://en.wikipedia.org/wiki/QR_decomposition).)

Now that we have some *X* we could solve for *Y*. If we proceeded in this fashion the algorithm guarantees convergence to a reasonable solution. 