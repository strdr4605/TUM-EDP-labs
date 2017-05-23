let game = new Phaser.Game(800, 600, Phaser.CANVAS, 'phaser-example', { preload: preload, create: create, update: update, render: render })

function preload() {
  game.load.image('ball', 'images/ball.png')
  game.load.image('box', 'images/box.png')
}

let ball
let balls
let created_balls

function create() {

  game.physics.startSystem(Phaser.Physics.ARCADE)

  balls = game.add.group()
  balls.enableBody = true
  createdBalls = game.add.group()
  createdBalls.enableBody = true

  for (let i = 0; i < 3; i++) {
    createObj(balls, Math.random() * 800, Math.random() * 800)
  }

}

function update () {

  game.physics.arcade.collide(balls, balls, ballsCollisionHandler, null, this)
  game.physics.arcade.collide(createdBalls, createdBalls, null, null, this)

  balls.forEach(el => reachBordersHandle(el))
  createdBalls.forEach(el => reachBordersHandle(el))
}

function ballsCollisionHandler (obj1, obj2) {

  createObj(createdBalls, obj1.body.position.x, obj1.body.position.y)

}

function createdBallsCollisionHandler (obj1, obj2) {

  createObj(balls, obj1.body.position.x, obj1.body.position.y)

}

function createObj (type, x, y) {
  let ball = type.create(x, y, 'ball')
  ball.scale.setTo(0.2)
  ball.body.velocity.setTo(Math.random() * 400, Math.random() * 400)
  ball.body.velocity.allowRotation = true
  ball.body.collideWorldBounds = true
  ball.body.bounce.set(1)
  ball.body.gravity.set(0)
}

let reachBordersHandle = el => {
  if (el.body.onWall()) {
    el.loadTexture('box', 0)
  }
  if (el.body.onCeiling() || el.body.onFloor()) {
    el.body.velocity.y += 50
    el.body.velocity.x += 50
  }
}

function render () {

  // game.debug.spriteInfo(ball, 32, 32)

}
