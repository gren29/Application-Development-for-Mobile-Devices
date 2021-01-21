using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Cube : MonoBehaviour
{
    public GameObject googleVR;
    public static float angleY;
    public static float angleX;
    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        //Debug.Log("CUBE "+ googleVR.GetComponent<GvrEditorEmulator>().mouseY);
        angleX = googleVR.transform.position.x;
        angleY = googleVR.transform.position.y;
        //Debug.Log("CUBE " + googleVR.GetComponent<GvrEditorEmulator>().mouseY);
        this.gameObject.transform.rotation = Quaternion.Euler(angleX, angleY, 0);

    }
}
