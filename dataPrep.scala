val rawUsersArtistData = sc.textFile("hdfs://localhost/user/spark/audioscrobbler/data/user_artist_data.txt")

rawUsersArtistData.map(_.split(' ')(0).toDouble).stats()
rawUsersArtistData.map(_.split(' ')(1).toDouble).stats()