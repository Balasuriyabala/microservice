const express = require("express");
const mongoose = require("mongoose");

const app = express();
app.use(express.json());

// Connect to MongoDB (container name = mongo)
mongoose.connect("mongodb://mongo:27017/usersdb", {
  useNewUrlParser: true,
  useUnifiedTopology: true,
});

const User = mongoose.model("User", new mongoose.Schema({
  name: String,
  email: String,
}));

// Routes
app.post("/users", async (req, res) => {
  const user = new User(req.body);
  await user.save();
  res.json(user);
});

app.get("/users", async (req, res) => {
  const users = await User.find();
  res.json(users);
});

app.listen(5000, () => console.log("User service running on port 5000"));
