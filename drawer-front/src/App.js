import { useState, useEffect } from 'react';
import { Stage, Layer, Line, Ellipse } from 'react-konva';
import axios from 'axios';

const App = () => {
  
  const [figureType, setFigureType] = useState(0);
  const [width, setWidth] = useState(100);
  const [height, setHeight] = useState(100);
  const [figures, setFigures] = useState([]);
  const [color, setColor] = useState("#FF0000");

  const handleCanvasClick = (e) => {
    console.log(figureType, width, height)
    axios.post('http://localhost:8080/get/figure', {
      figureType : figureType,
      width : width,
      height : height,
      posX : e.evt.clientX,
      posY : e.evt.clientY
     })
    .then((response) => {
      drawFigure(response.data);
    })
    .catch((error) => {
      console.log(error);
    });
  }

  const drawFigure = (data) => {
    if ('angles' in data) 
      setFigures([...figures, 
        <Line
          points={data.angles}
          tension={0}
          closed
          stroke="black"
          // fillLinearGradientStartPoint={{ x: -50, y: -50 }}
          // fillLinearGradientEndPoint={{ x: 50, y: 50 }}
          // fillLinearGradientColorStops={[0, 'red', 1, 'yellow']}
          fill={color}
        />
      ])
    else
      setFigures([...figures,
        <Ellipse
          x={data.posX}
          y={data.posY}
          radiusX={data.radiusX}
          radiusY={data.radiusY}
          closed
          stroke="black"
          // fillLinearGradientStartPoint={{ x: -50, y: -50 }}
          // fillLinearGradientEndPoint={{ x: 50, y: 50 }}
          // fillLinearGradientColorStops={[0, 'red', 1, 'yellow']}
          fill={color}
        />
      ])
      
  }

  return (
    <div className="App">
      <div className="panel">
          <label htmlFor="figuresSelect">Choose a figure:</label>
          <select
            id="figuresSelect"
            value={figureType}
            onChange={(e) => setFigureType(e.target.value)}>
              <option value="0">Rectangle</option>
              <option value="1">Square</option>
              <option value="2">Circle</option>
              <option value="3">Ellipse</option>
              <option value="4">Triangle</option>
          </select>

          <label htmlFor="width">Width</label>
          <input
            type="text"
            id="width"
            value={width}
            onChange={(e) => setWidth(e.target.value)} />

          <label htmlFor="height">Height</label>
          <input
            type="text"
            id="height"
            value={height}
            onChange={(e) => setHeight(e.target.value)} />

          <input type="color" value={color} onChange={(e) => setColor(e.target.value)}/>

          <button onClick={(e) => setFigures([])}>Clear</button>


      </div>
      
      <Stage className="stage" width={window.innerWidth} height={window.innerHeight} onClick={handleCanvasClick}>
        <Layer className="layer" >
          {figures}
        </Layer>
      </Stage>
    </div>
  );
}

export default App;
